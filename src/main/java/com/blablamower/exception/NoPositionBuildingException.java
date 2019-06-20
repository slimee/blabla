package com.blablamower.exception;

public class NoPositionBuildingException extends WorldBuildingException {
    public NoPositionBuildingException(String message) {
        super(message);
    }
    public NoPositionBuildingException(String message, Throwable cause) {
        super(message, cause);
    }
}
