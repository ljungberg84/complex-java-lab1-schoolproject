package se.alten.schoolproject.rest;

import lombok.NoArgsConstructor;
import se.alten.schoolproject.dao.SchoolAccessLocal;
import se.alten.schoolproject.entity.Student;
import se.alten.schoolproject.error.MyException;
import se.alten.schoolproject.model.StudentModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Stateless
@NoArgsConstructor
@Path("/student")
public class StudentController {

    private static final Logger logger = Logger.getLogger("StudentController");


    @Inject
    private SchoolAccessLocal schoolAccessLocal;


    @GET
    @Produces(APPLICATION_JSON)
    public Response listStudents() throws Exception{

        List<Student> students = schoolAccessLocal.listAllStudents();
        return Response.ok(students).build();
    }


    @GET
    @Produces(APPLICATION_JSON)
    @Path("/{email}")
    public Response getStudent(){

        return Response.noContent().build();
    }


    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response addStudent(String requestBody, @Context UriInfo uriInfo) throws Exception {

        StudentModel studentModel = StudentModel.create(requestBody);

        StudentModel student = schoolAccessLocal.addStudent(studentModel);
        URI createdURI = uriInfo.getBaseUriBuilder().path(student.getEmail()).build();

        return Response.status(Response.Status.CREATED).entity(createdURI).build();
    }


    @DELETE
    @Path("{email}")
    public Response deleteUser( @PathParam("email") String email) {

        schoolAccessLocal.removeStudent(email);

        return Response.status(Response.Status.NO_CONTENT).build();
    }


    @PUT
    public void updateStudent( @QueryParam("firstName") String forename, @QueryParam("lastName") String lastname, @QueryParam("email") String email) {

        schoolAccessLocal.updateStudent(forename, lastname, email);
    }

//    @PUT
//    public void updateStudent( @QueryParam("firstName") String forename, @QueryParam("lastName") String lastname, @QueryParam("email") String email) {
//
//        schoolAccessLocal.updateStudent(forename, lastname, email);
//    }


    @PATCH
    public void updatePartialAStudent(String studentModel) {
        schoolAccessLocal.updateStudentPartial(studentModel);
    }
}
