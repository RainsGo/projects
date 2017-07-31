package com.rainsgo.server.api;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rain on 17-7-31.
 */
@Log4j2
@EnableWebMvc
@RestControllerAdvice
public class ApiResultExceptionHandler extends Throwable{

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResultBody notFoundException(HttpServletResponse response, Exception exception) {
        //return new ResponseEntity<>(new ApiResultBody(exception, HttpStatus.NOT_FOUND.value()), HttpStatus.valueOf(response.getStatus()));
        //return new ApiResultBody(exception, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ApiResultBody(exception, HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResultBody internalServerErrorException(HttpServletResponse response, Exception exception){
        //return new ResponseEntity<>(new ApiResultBody(exception), HttpStatus.valueOf(response.getStatus()));
        if(exception instanceof ApiException){
            return new ApiResultBody(exception);
        }

        //return new ApiResultBody(exception, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ApiResultBody(exception, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
