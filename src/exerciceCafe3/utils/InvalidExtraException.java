package exerciceCafe3.utils;

public class InvalidExtraException extends Exception {

    public InvalidExtraException(String message) {
        super(message);
    }

    public InvalidExtraException(String message, Exception cause) {
        super(message, cause);
    }
}
