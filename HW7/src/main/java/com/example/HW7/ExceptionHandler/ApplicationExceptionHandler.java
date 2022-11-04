package com.example.HW7.ExceptionHandler;

import com.example.HW7.ResponseStatusException.ShopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "Requested Shop Not Found")
    @ExceptionHandler(ShopNotFoundException.class)
    public void handleException(ShopNotFoundException e) {
    }
}
