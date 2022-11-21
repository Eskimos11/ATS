package exceptions;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class NotFoundCardException extends RuntimeException {

    public NotFoundCardException(String message) {
        super(message);
    }

    public NotFoundCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundCardException(Throwable cause) {
        super(cause);
    }

    public NotFoundCardException() {
    }
}
