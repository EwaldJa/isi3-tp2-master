package exerciceCafe3.utils;

public class InvalidDrinkException extends Exception {

    public InvalidDrinkException(String message) {
        super(message);
    }

    public InvalidDrinkException(String message, Exception cause) {
        super(message, cause);
    }
}
