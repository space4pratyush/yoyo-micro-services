package com.pratyush.userservice.exception;

public class NoSuchUserFound extends ServiceException{
    public NoSuchUserFound() {
        super();
    }

    public NoSuchUserFound(String message) {
        super(message);
    }

    public NoSuchUserFound(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchUserFound(Throwable cause) {
        super(cause);
    }

    protected NoSuchUserFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
