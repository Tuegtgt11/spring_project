package com.tass.productservice.model;

import lombok.Data;

@Data
public class BaseResponse {
    private int code;
    private String message;
    private Object data;

    public BaseResponse(){
        this.code = 1;
        this.message = "SUCCESS";
        this.data= getData();
    }

    public BaseResponse(ERROR error){
        this.code = error.code;
        this.message = error.message;
        this.data = error.data;
    }

    public BaseResponse(int code, String messsage, Object data){
        this.code = code;
        this.message = messsage;
        this.data = data;
    }
}