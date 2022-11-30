package com.tass.productservice.model;

import lombok.Data;

@Data
public class ApiException extends RuntimeException{
    public ApiException(){
        super();
    }

    private int code;
    private Object data;

    public ApiException(int code , String message, Object data){
        super(message);
        this.code = code;
        this.data = data;
    }

    public ApiException(ERROR error){
        super(error.message);
        this.code = error.code;
        this.data = error.data;
    }

    public ApiException(ERROR error , String message){
        super(message);
        this.code = error.code;
        this.data = error.data;
    }
}
