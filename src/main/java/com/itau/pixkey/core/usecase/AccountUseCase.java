package com.itau.pixkey.core.usecase;

import com.itau.pixkey.core.domain.*;
import com.itau.pixkey.core.exception.AccountWithThisCheckingNotFoundException;
import com.itau.pixkey.core.exception.EntityNotFoundException;
import com.itau.pixkey.core.exception.ExistsAccountException;
import com.itau.pixkey.core.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.itau.pixkey.core.domain.AccountType.CHECKING;

@Service
@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountGateway accountGateway;

    public Account insert(Account account) {
        if (accountGateway.exists(account.getAgency(), account.getAccountNumber())) {
            throw new ExistsAccountException(account.getAgency(), account.getAccountNumber());
        }

        return accountGateway.insert(account);
    }

    public Account update(Account account) {
        return accountGateway.insert(account);
    }

    public Account searchCheckingAccountById(final UUID accountId) {
        return accountGateway.searchCheckingAccountById(CHECKING, accountId).orElseThrow(() -> new AccountWithThisCheckingNotFoundException(accountId));
    }

}
