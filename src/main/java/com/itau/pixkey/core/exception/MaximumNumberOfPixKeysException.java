package com.itau.pixkey.core.exception;

public class MaximumNumberOfPixKeysException extends BusinessException {
    public MaximumNumberOfPixKeysException() {
        super("This account has reached the maximum number of pix keys");
    }

}
