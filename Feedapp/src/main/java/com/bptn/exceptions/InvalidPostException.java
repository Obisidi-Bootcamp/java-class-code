package com.bptn.exceptions;

import net.bytebuddy.implementation.bytecode.Throw;

public class InvalidPostException extends Exception {

    public InvalidPostException(){
        super();
    }

    public InvalidPostException(String msg){
        super(msg);
    }

    public InvalidPostException(String msg, Throwable cause){
        super(msg, cause);
    }

    public InvalidPostException(Throwable cause){
        super(cause);
    }

}
