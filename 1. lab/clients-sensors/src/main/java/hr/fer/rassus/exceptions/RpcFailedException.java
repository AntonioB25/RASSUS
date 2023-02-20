package hr.fer.rassus.exceptions;

public class RpcFailedException extends RuntimeException{
    public RpcFailedException(String message) {
        super(message);
    }
}
