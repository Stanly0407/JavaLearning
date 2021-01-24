package customExceptions;

// example
public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String username) {
        super(String.format("Invalid password for user %s", username));
    }
}
