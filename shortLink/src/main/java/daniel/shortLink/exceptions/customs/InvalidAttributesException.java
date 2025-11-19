package daniel.shortLink.exceptions.customs;

public class InvalidAttributesException extends RuntimeException {
    public InvalidAttributesException(String message) {
        super(message);
    }
    public InvalidAttributesException(String message, Throwable cause) {
        super(message, cause);
    }
}
