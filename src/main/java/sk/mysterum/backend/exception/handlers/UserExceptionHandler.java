package sk.mysterum.backend.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sk.mysterum.backend.exception.UserAlreadyExistsException;
import sk.mysterum.backend.exception.UserDoesNotExistException;
import sk.mysterum.backend.exception.WindowAlreadyOpenedException;
import sk.mysterum.backend.requestmodel.GenericResponse;

import javax.naming.directory.InvalidAttributeIdentifierException;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(WindowAlreadyOpenedException.class)
    public ResponseEntity<GenericResponse<String>> handleWindowAlreadyOpenedException(WindowAlreadyOpenedException exception) {
        return new ResponseEntity<>(new GenericResponse<>(exception.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<GenericResponse<String>> handleUserDoesNotExistException(UserDoesNotExistException exception) {
        return new ResponseEntity<>(new GenericResponse<>(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<GenericResponse<String>> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return new ResponseEntity<>(new GenericResponse<>(exception.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidAttributeIdentifierException.class)
    public ResponseEntity<GenericResponse<String>> handleInvalidAttributeIdentifierException(InvalidAttributeIdentifierException exception) {
        return new ResponseEntity<>(new GenericResponse<>("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
