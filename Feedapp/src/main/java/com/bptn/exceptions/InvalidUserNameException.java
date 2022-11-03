package com.bptn.exceptions;

public class InvalidUserNameException extends Exception{
    public InvalidUserNameException() {
        super();
    }

    public InvalidUserNameException(String message) {
        super(message);
    }

    public InvalidUserNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserNameException(Throwable cause) {
        super(cause);
    }

}
