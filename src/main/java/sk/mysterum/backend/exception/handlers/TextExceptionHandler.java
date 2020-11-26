package sk.mysterum.backend.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sk.mysterum.backend.exception.WrongPasswordException;
import sk.mysterum.backend.requestmodel.GenericResponse;

@RestControllerAdvice
public class TextExceptionHandler {
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<GenericResponse<String>> handleFormatException(NumberFormatException e){

        return new ResponseEntity<>(new GenericResponse<>("Day cannot be a string"), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<GenericResponse<String>> handleWrongPasswordException(WrongPasswordException e){

        return new ResponseEntity<>(new GenericResponse<>(e.getMessage()), HttpStatus.UNAUTHORIZED);

    }
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<GenericResponse<String>> handleIndexOutOfBoundsException(IndexOutOfBoundsException e){

        return new ResponseEntity<>(new GenericResponse<>("No data for this day"), HttpStatus.GONE);

    }

}
