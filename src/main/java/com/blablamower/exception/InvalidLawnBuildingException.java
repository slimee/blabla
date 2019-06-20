package com.blablamower.exception;

public class InvalidLawnBuildingException extends WorldBuildingException {
    public InvalidLawnBuildingException(String message) {
        super(message);
    }
    public InvalidLawnBuildingException(String message, Throwable cause) {
        super(message, cause);
    }
}
