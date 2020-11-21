package sk.mysterum.backend.exception;

public class WrongPasswordException extends Throwable{
    public WrongPasswordException() {
        super("Wrong Password");
    }
}
