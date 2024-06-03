package com.itau.pixkey.core.usecase;

import com.itau.pixkey.core.domain.*;
import com.itau.pixkey.core.exception.AccountWithThisCheckingNotFoundException;
import com.itau.pixkey.core.exception.ExistsAccountException;
import com.itau.pixkey.core.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Account searchCheckingAccount(final Integer agency, final Integer accountNumber) {
        return accountGateway.search(CHECKING, agency, accountNumber).orElseThrow(() -> new AccountWithThisCheckingNotFoundException(agency, accountNumber));
    }

}
