package sk.mysterum.backend.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sk.mysterum.backend.exception.UserDoesNotExistException;
import sk.mysterum.backend.exception.WindowAlreadyOpenedException;
import sk.mysterum.backend.requestmodel.Response;

import javax.naming.directory.InvalidAttributeIdentifierException;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(WindowAlreadyOpenedException.class)
    public ResponseEntity<Response> handleWindowAlreadyOpenedException(WindowAlreadyOpenedException exception) {
        return new ResponseEntity<>(new Response(exception.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<Response> handleUserDoesNotExistException(UserDoesNotExistException exception) {
        return new ResponseEntity<>(new Response(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAttributeIdentifierException.class)
    public ResponseEntity<Response> handleInvalidAttributeIdentifierException(InvalidAttributeIdentifierException exception) {
        return new ResponseEntity<>(new Response("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
