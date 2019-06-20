package com.blablamower.exception;

public class InvalidPositionBuildingException extends WorldBuildingException {
    public InvalidPositionBuildingException(String message) {
        super(message);
    }
    public InvalidPositionBuildingException(String message, Throwable cause) {
        super(message, cause);
    }
}
