package com.pratyush.userservice.exception;

public class ProductBrandNotFound extends ServiceException{
    public ProductBrandNotFound() {
        super();
    }

    public ProductBrandNotFound(String message) {
        super(message);
    }

    public ProductBrandNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductBrandNotFound(Throwable cause) {
        super(cause);
    }

    protected ProductBrandNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
