package com.itau.pixkey.entrypoint.api.controller;

import com.itau.pixkey.core.usecase.AccountUseCase;
import com.itau.pixkey.entrypoint.api.controller.contract.AccountControllerApi;
import com.itau.pixkey.entrypoint.api.controller.mapper.AccountMapper;
import com.itau.pixkey.entrypoint.api.controller.payload.AccountDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.AccountInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "AccountController", description = "Manage the account")
public class AccountController implements AccountControllerApi {

    private final AccountUseCase accountUseCase;
    private final AccountMapper accountMapper;

    @Operation(summary = "Create a account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "create a account with successful")
    })
    @Override
    public AccountDTO insert(AccountInput accountInput) {
        var account = accountUseCase.insert(accountMapper.toDomainObject(accountInput));
        return accountMapper.toResponse(account);
    }

}
