package customExceptions;

// example
public class NoSuchEntityException extends Exception {

    public NoSuchEntityException(String message) {
        super(String.format("No such entity: %s ", message));
    }
}
