package exceptions;

public class InvalidMapException extends RuntimeException {
    public InvalidMapException(String message) {
        super(message);
    }

    public InvalidMapException(String message,Throwable cause){
        super(message, cause);
    }
}
