package com.itau.pixkey.entrypoint.api.controller.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class PixKeyWithDatesDTO {

    private UUID id;
    private KeyType keyType;
    private Status status;
    private String keyValue;

    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss'Z'")
    private OffsetDateTime registrationDate;

    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss'Z'")
    private OffsetDateTime updateDate;

    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss'Z'")
    private OffsetDateTime inactivationDate;

}
