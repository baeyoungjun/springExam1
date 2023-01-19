package com.example.firstProject.exception;

import com.example.firstProject.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InternalServerException extends RuntimeException {

    /** default 500 Error **/
    public InternalServerException() {
        log.info(ReturnCode.E_500.getJson().toString());
    }

}
