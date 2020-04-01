package com.lairun.common.advice.exception;

/**
 * @author x_holic@outlook.com
 * @date 2020-04-01
 */
public class UserNotLoginException extends RuntimeException {

    public UserNotLoginException(String message) {
        super(message);
    }
}
