package com.test.hexagonal.commons.infraestructure.exceptions;
public class ServerErrorException extends RuntimeException{
    public ServerErrorException(Throwable cause){
        super("Internal Server Error");
        System.err.println(cause);
    }
}
