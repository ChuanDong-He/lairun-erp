package com.lairun.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-12
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = {Exception.class})
    public Map<String, Object> exception(Exception exception){
        Map<String, Object> result = new HashMap<>();
        log.debug(exception.getMessage());

        return result;
    }

}
