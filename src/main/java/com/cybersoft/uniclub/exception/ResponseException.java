package com.cybersoft.uniclub.exception;

import com.cybersoft.uniclub.payload.response.BaseResponse;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseException {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<?> handleException(RuntimeException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(500);
        baseResponse.setMessage(e.getMessage());
        baseResponse.setData("");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleValidException(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(item -> {
            String field = ((FieldError) item).getField();
            String message = item.getDefaultMessage();
            errors.put(field,message);
        });

        Gson gson = new Gson();

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(400);
        baseResponse.setMessage(gson.toJson(errors));
        baseResponse.setData("");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);

    }
}
