package com.mndlovu.exception;

/**
 * custom checked Exception
 * @author mndlovu
 * @since 15-06-2018
 */
public class InvalidFileFormatException extends Exception {

    public InvalidFileFormatException() {
        super();
    }

    public InvalidFileFormatException(String message) {
        super(message);
    }
}
