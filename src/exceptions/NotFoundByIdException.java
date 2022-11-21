package exceptions;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class NotFoundByIdException extends RuntimeException {
    public NotFoundByIdException(String message) {
        super(message);
    }

    public NotFoundByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundByIdException() {
    }

    public NotFoundByIdException(Throwable cause) {
        super(cause);

    }
}
