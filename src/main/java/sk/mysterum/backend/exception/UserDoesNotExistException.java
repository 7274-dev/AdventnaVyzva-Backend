package sk.mysterum.backend.exception;

public class UserDoesNotExistException extends Throwable {
    public UserDoesNotExistException() {
        super("User doesn't exist");
    }
}
