package sk.mysterum.backend.exception.handlers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sk.mysterum.backend.exception.FileAlreadyExistsException;
import sk.mysterum.backend.exception.WrongPasswordException;
import sk.mysterum.backend.requestmodel.Response;

@RestControllerAdvice
public class FIleAlreadyExistsExceptionHandler {


    @ExceptionHandler(FileAlreadyExistsException.class)
    public ResponseEntity<Response> handleWrongPasswordException(WrongPasswordException e){
        return new ResponseEntity<Response>(new Response("File Already Exists"), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
