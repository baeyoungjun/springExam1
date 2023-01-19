package com.example.firstProject.exception;

import com.example.firstProject.util.ReturnCode;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({InternalServerException.class, Exception.class})
    //@ResponseStatus(HttpStatus.OK)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody JSONObject internalServer500( Exception e) {e.printStackTrace(); return ReturnCode.E_500.getJson();}

    @ExceptionHandler({BadRequestException.class, MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody JSONObject badRequest400(Exception e) {e.printStackTrace(); return ReturnCode.E_400.getJson();}

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody JSONObject unauthorized401(Exception e) {e.printStackTrace(); return ReturnCode.E_401.getJson();}

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody JSONObject forbidden403(Exception e) {e.printStackTrace(); return ReturnCode.E_403.getJson();}


}
