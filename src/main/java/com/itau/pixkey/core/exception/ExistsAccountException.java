package com.itau.pixkey.core.exception;

public class ExistsAccountException extends ExistsException {
    public ExistsAccountException(final Integer agency, final Integer accountNumber) {
        super(String.format("There is already a account with %d agency and %d account number", agency, accountNumber));
    }

}
