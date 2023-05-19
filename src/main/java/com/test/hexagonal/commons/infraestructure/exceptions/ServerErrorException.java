package com.test.hexagonal.commons.infraestructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException{
    public ServerErrorException(Throwable cause){
        super("Internal Server Error");
        System.err.println(cause);
    }
}
