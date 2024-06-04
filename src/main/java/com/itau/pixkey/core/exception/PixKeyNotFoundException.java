package com.itau.pixkey.core.exception;

import java.util.UUID;

public class PixKeyNotFoundException extends EntityNotFoundException {

    public PixKeyNotFoundException(UUID id) {
        super(String.format("There isn't pix key with this id %s", id));
    }

}
