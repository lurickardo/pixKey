package com.itau.pixkey.entrypoint.api.controller.contract;

import com.itau.pixkey.entrypoint.api.controller.payload.AccountDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.AccountInput;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/account")
public interface AccountControllerApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AccountDTO insert(@RequestBody @Valid final AccountInput accountInput);

}
