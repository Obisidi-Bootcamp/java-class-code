package com.bptn.exceptions;

public class InvalidQueryException extends Exception{

    public InvalidQueryException() {
        super();
    }

    public InvalidQueryException(String msg) {
        super(msg);
    }

    public InvalidQueryException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidQueryException(Throwable cause) {
        super(cause);
    }
}
