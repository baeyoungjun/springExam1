package com.example.firstProject.exception;

import com.example.firstProject.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForbiddenException extends RuntimeException {

    /** default 403 Error **/
    public ForbiddenException() {
        log.info(ReturnCode.E_403.getJson().toString());
    }
}
