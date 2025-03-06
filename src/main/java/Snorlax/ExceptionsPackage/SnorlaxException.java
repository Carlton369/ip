package Snorlax.ExceptionsPackage;

/**
 * Parent Exception class, to be overridden by the corresponding exception.
 *
 */
public abstract class SnorlaxException extends RuntimeException {

    public SnorlaxException() {
        super();
    }

    /**
     * Abstract method to be overriden by children
     *
     */
    public abstract void handle();
}
