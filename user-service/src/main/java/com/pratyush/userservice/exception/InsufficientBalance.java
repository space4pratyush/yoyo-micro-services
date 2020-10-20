package com.pratyush.userservice.exception;

public class InsufficientBalance extends ServiceException{
    public InsufficientBalance() {
        super();
    }

    public InsufficientBalance(String message) {
        super(message);
    }

    public InsufficientBalance(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientBalance(Throwable cause) {
        super(cause);
    }

    protected InsufficientBalance(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
