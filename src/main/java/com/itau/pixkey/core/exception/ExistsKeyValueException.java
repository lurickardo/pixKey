package com.itau.pixkey.core.exception;

public class ExistsKeyValueException extends ExistsException {
    public ExistsKeyValueException(String keyValue) {
        super(String.format("There is already a key value equal to this %s", keyValue));
    }

}
