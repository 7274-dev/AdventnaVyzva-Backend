package sk.mysterum.backend.exception;

public class FileDoesntExistException extends Throwable{
    public FileDoesntExistException(){super("File Already Exists");}
}
