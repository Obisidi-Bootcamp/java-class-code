package com.bptn.exceptions;

public class InvalidImageMetaDataException extends Exception{
    public InvalidImageMetaDataException() {
        super();
    }

    public InvalidImageMetaDataException(String msg) {
        super(msg);
    }

    public InvalidImageMetaDataException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidImageMetaDataException(Throwable cause) {
        super(cause);
    }
}
