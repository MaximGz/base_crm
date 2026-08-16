package ru.mts.exceptions;

public class ClientBlockedException extends RuntimeException{
    public ClientBlockedException(String message) {
        super(message);
    }
}
