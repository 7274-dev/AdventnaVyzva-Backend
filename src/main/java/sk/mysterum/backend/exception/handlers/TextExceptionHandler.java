package sk.mysterum.backend.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sk.mysterum.backend.exception.WrongPasswordException;
import sk.mysterum.backend.requestmodel.Response;

@RestControllerAdvice
public class TextExceptionHandler {
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Response> handleFormatException(NumberFormatException e){

        return new ResponseEntity<Response>(new Response("Day cannot be a string"), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<Response> handleWrongPasswordException(WrongPasswordException e){

        return new ResponseEntity<Response>(new Response(e.getMessage()), HttpStatus.UNAUTHORIZED);

    }
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<Response> handleIndexOutOfBoundsException(IndexOutOfBoundsException e){

        return new ResponseEntity<Response>(new Response("No data for this day"), HttpStatus.GONE);

    }

}
