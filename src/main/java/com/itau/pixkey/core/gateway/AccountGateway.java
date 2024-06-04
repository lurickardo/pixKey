package com.itau.pixkey.core.gateway;

import com.itau.pixkey.core.domain.Account;
import com.itau.pixkey.core.domain.AccountType;

import java.util.Optional;
import java.util.UUID;

public interface AccountGateway {

    Account insert(final Account account);
    Optional<Account> searchCheckingAccountById(final AccountType accountType, final UUID accountId);
    Boolean exists(final Integer agency, final Integer accountNumber);
}
