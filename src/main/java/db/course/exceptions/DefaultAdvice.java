package db.course.exceptions;

import org.hibernate.exception.GenericJDBCException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(GenericJDBCException.class)
    public ResponseEntity<Response> handleException(GenericJDBCException e) {
        System.out.println("here is an exception" + e.getSQLException());
        Response response = new Response();
        response.setMessage((e.getSQLException().getLocalizedMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<Response> handleException(JpaSystemException e) {
        System.out.println("here is an exception" + e.getMostSpecificCause().getMessage());
        e.printStackTrace();
        Response response = new Response();
        response.setMessage((e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}