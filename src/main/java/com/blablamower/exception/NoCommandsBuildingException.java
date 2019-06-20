package com.blablamower.exception;

public class NoCommandsBuildingException extends WorldBuildingException {
    public NoCommandsBuildingException(String message) {
        super(message);
    }
    public NoCommandsBuildingException(String message, Throwable cause) {
        super(message, cause);
    }
}
