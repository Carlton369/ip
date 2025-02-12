package ExceptionsPackage;

public abstract class SnorlaxException extends RuntimeException {

    public SnorlaxException() {
        super();
    }

    public abstract void handle();
}
