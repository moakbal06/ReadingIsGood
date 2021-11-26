package com.erkan.reading.is.good.exception;

public class OrderNotFoundException extends BusinessException {
    private static final String errorCode = "000003";
    private static final String errorMessage = "Order Not Found";

    public OrderNotFoundException() {
        super(errorCode, errorMessage);
    }
}