package com.cybersoft.uniclub.exception;

import com.cybersoft.uniclub.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseException {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<?> handleException(Exception e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(500);
        baseResponse.setMessage(e.getMessage());
        baseResponse.setData("");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
