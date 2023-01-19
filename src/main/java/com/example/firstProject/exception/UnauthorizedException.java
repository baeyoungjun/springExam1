package com.example.firstProject.exception;

import com.example.firstProject.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnauthorizedException extends RuntimeException {

    /** default 401 Error **/
    public UnauthorizedException() {
        log.info(ReturnCode.E_401.getJson().toString());
    }
}
