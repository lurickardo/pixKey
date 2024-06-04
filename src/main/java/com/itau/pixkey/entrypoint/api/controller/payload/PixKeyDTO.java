package com.itau.pixkey.entrypoint.api.controller.payload;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PixKeyDTO {

    private UUID id;
    private KeyType keyType;
    private Status status;
    private String keyValue;

}
