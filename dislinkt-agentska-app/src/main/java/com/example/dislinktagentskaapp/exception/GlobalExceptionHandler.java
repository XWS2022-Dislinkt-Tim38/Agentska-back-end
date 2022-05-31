package com.example.dislinktagentskaapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String objectNotFound(){
        return "Entity not found!";
    }

    @ExceptionHandler(UsernameExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String userAlreadyExists(UsernameExistsException e){
        LOGGER.error(e.getMessage(), e);
        return "User already exists!";
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String userNotFound(UserNotFoundException e){
        LOGGER.error(e.getMessage(), e);
        return "User not found!";
    }

    @ExceptionHandler(RequestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String requestNotFound(RequestNotFoundException e){
        LOGGER.error(e.getMessage(), e);
        return "Request not found!";
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String companyNotFound(CompanyNotFoundException e){
        LOGGER.error(e.getMessage(), e);
        return "Company not found!";
    }

}
