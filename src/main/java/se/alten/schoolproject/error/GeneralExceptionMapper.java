package se.alten.schoolproject.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class GeneralExceptionMapper implements ExceptionMapper <Exception> {

    private static final Logger logger = Logger.getLogger("GeneralExceptionMapper");


    @Override
    public Response toResponse(Exception e) {

        logger.info(e.getMessage());
        if(e instanceof MyException){

            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(e.getMessage())).build();
        }

        if(e instanceof ResourceCreationException){

            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(e.getMessage())).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
