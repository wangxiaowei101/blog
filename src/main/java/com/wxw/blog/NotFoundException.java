package com.wxw.blog;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wxw
 * @data 2020/3/5 16 :13
 * @description
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends  RuntimeException {
    

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
