package com.itau.pixkey.entrypoint.api.controller.mapper;

import com.itau.pixkey.core.domain.Account;
import com.itau.pixkey.entrypoint.api.controller.payload.AccountDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.AccountInput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final ModelMapper modelMapper;

    public Account toDomainObject(final AccountInput accountInput) {
        return modelMapper.map(accountInput, Account.class);
    }

    public AccountDTO toResponse(final Account account) {
        return modelMapper.map(account, AccountDTO.class);
    }

}
