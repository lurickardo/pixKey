package com.itau.pixkey.entrypoint.api.controller.payload.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountIdInput {

    @NotNull
    private UUID id;

}
