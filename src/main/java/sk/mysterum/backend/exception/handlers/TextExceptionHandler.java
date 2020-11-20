package sk.mysterum.backend.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sk.mysterum.backend.model.Response;

@RestControllerAdvice
public class TextExceptionHandler {
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Response> handleFormatException(NumberFormatException e){

        return new ResponseEntity<Response>(new Response("Day cannot be a string"), HttpStatus.BAD_REQUEST);

    }
}
