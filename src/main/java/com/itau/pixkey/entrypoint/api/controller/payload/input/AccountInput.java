package com.itau.pixkey.entrypoint.api.controller.payload.input;

import com.itau.pixkey.core.domain.AccountType;
import com.itau.pixkey.core.domain.PersonCategory;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountInput {

    @NotNull
    private PersonCategory personCategory;

    @NotNull
    private AccountType accountType;

    @NotNull
    @Positive
    @Max(9999)
    private Integer agency;

    @NotNull
    @Positive
    @Max(99999999)
    private Integer accountNumber;

    @NotBlank
    @Size(max = 30)
    private String holderName;

    @Size(max = 45)
    private String holderSurname;

}
