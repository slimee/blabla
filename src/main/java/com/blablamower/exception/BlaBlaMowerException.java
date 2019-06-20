package com.blablamower.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BlaBlaMowerException extends RuntimeException {
    public BlaBlaMowerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlaBlaMowerException(String message) {
        super(message);
    }
}
