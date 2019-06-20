package com.blablamower.exception;

public class NoLawnBuildingException extends WorldBuildingException {
    public NoLawnBuildingException(String message) {
        super(message);
    }
    public NoLawnBuildingException(String message, Throwable cause) {
        super(message, cause);
    }
}
