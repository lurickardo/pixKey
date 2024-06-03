package com.itau.pixkey.core.exception;

public class AccountWithThisCheckingNotFoundException extends EntityNotFoundException {

    public AccountWithThisCheckingNotFoundException(Integer agency, Integer accountNumber) {
        super(String.format("There isn't account with this checking with %d agency and %d account number", agency, accountNumber));
    }

}
