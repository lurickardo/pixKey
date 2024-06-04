package com.itau.pixkey.core.exception;

import java.util.UUID;

public class AccountWithThisCheckingNotFoundException extends EntityNotFoundException {


    public AccountWithThisCheckingNotFoundException(UUID acountId) {
        super(String.format("There isn't account with this checking with this id", acountId));
    }

}
