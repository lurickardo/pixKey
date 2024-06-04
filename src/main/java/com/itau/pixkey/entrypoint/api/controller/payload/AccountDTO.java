package com.itau.pixkey.entrypoint.api.controller.payload;

import com.itau.pixkey.core.domain.AccountType;
import com.itau.pixkey.core.domain.PersonCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountDTO {

    private UUID id;
    private PersonCategory personCategory;
    private AccountType accountType;
    private Integer agency;
    private Integer accountNumber;
    private String holderName;
    private String holderSurname;

}
