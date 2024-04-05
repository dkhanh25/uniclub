package com.cybersoft.uniclub.exception;

import lombok.Getter;
import lombok.Setter;

public class InsertException extends RuntimeException{

    @Getter
    @Setter
    private String message;

    public InsertException(String message) {
        this.message = message;
    }
}
