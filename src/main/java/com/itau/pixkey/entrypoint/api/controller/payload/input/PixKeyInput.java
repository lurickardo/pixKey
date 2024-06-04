package com.itau.pixkey.entrypoint.api.controller.payload.input;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.entrypoint.api.controller.validation.PixKey;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PixKey
public class PixKeyInput {

    @NotNull
    private KeyType keyType;

    @NotBlank
    @Size(max = 77)
    private String keyValue;

    @Valid
    @NotNull
    private AccountIdInput account;

}
