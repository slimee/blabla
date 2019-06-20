package com.blablamower.exception;

public class InvalidCommandsBuildingException extends WorldBuildingException {
    public InvalidCommandsBuildingException(String message) {
        super(message);
    }
    public InvalidCommandsBuildingException(String message, Throwable cause) {
        super(message, cause);
    }
}
