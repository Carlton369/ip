package Snorlax.ExceptionsPackage;

//parent exception class, to be overridden by the corresponding exception
public abstract class SnorlaxException extends RuntimeException {

    public SnorlaxException() {
        super();
    }

    public abstract void handle();
}
