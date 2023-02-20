package hr.fer.rassus.exceptions;

public class RowNotFoundException extends RuntimeException {
    public RowNotFoundException() {
        super();
    }

    public RowNotFoundException(String message) {
        super(message);
    }
}
