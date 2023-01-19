package com.example.firstProject.exception;

import com.example.firstProject.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BadRequestException extends RuntimeException {

    /** default 400 Error **/
    public BadRequestException() {
        log.info(ReturnCode.E_400.getJson().toString());
    }

}
