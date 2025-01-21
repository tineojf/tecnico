package com.tineo.reto.exception;

public class EntityAlreadeExistsException extends RuntimeException {
    public EntityAlreadeExistsException(String message) {
        super(message);
    }
}
