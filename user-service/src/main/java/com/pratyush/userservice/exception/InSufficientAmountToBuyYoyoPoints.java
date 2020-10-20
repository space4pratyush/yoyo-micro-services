package com.pratyush.userservice.exception;

public class InSufficientAmountToBuyYoyoPoints extends ServiceException{

    public InSufficientAmountToBuyYoyoPoints() {
        super();
    }

    public InSufficientAmountToBuyYoyoPoints(String message) {
        super(message);
    }

    public InSufficientAmountToBuyYoyoPoints(String message, Throwable cause) {
        super(message, cause);
    }

    public InSufficientAmountToBuyYoyoPoints(Throwable cause) {
        super(cause);
    }

    protected InSufficientAmountToBuyYoyoPoints(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
