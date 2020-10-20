package com.pratyush.userservice.exception;

public class PasswordDidNotMatch extends ServiceException{
    public PasswordDidNotMatch() {
        super();
    }

    public PasswordDidNotMatch(String message) {
        super(message);
    }

    public PasswordDidNotMatch(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordDidNotMatch(Throwable cause) {
        super(cause);
    }

    protected PasswordDidNotMatch(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
