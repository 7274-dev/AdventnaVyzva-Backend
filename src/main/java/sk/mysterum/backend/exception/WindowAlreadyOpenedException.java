package sk.mysterum.backend.exception;

import net.bytebuddy.implementation.bytecode.Throw;

public class WindowAlreadyOpenedException extends Throwable {
    public WindowAlreadyOpenedException() {
        super("Window already opened");
    }
}
