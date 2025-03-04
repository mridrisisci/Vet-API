package app;

import app.controllers.AppointmentController;
import app.controllers.PatientController;
import app.dtos.PatientDTO;
import io.javalin.Javalin;
import app.dtos.AppointmentDTO;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main
{
    static AppointmentController appointmentController = new AppointmentController();
    static PatientController patientController = new PatientController();

    public static void main(String[] args)
    {

        Javalin app = Javalin.create(config ->
        {
            config.router.contextPath = "/api";
            config.router.apiBuilder(() ->
            {
                path("/vet", () ->
                {
                    get("/", (ctx) -> ctx.json(appointmentController.getAll()));

                    get("/appointments", (ctx) ->
                    {
                        try
                        {
                            ctx.json(appointmentController.getUpcoming());
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    });

                    get("/patients", (ctx) ->
                    {
                        ctx.json(patientController.getAll());
                    });
                    get("/patient/details/{id}", (ctx) ->
                    {
                        try
                        {
                            PatientDTO dto = patientController.getById(Integer.parseInt(ctx.pathParam("id"))-1);
                            //PatientDTO dto = patientController.getById(id);
                            ctx.json(dto);
                        } catch (Exception e)
                        {
                            ctx.status(404).result("patient not found");
                            e.printStackTrace();
                        }
                    });
                    post("/patients/addpatient", ctx ->
                    {
                        try
                        {
                            PatientDTO dto = ctx.bodyAsClass(PatientDTO.class);
                            PatientDTO newPatient = patientController.create(dto);
                            ctx.json(newPatient);
                        } catch (Exception e)
                        {
                            ctx.status(500).result("server error");
                            e.printStackTrace();
                        }
                    });
                });
            });
        }).start(7000);
    }
}