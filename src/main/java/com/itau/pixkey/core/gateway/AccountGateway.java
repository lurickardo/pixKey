package com.itau.pixkey.core.gateway;

import com.itau.pixkey.core.domain.Account;
import com.itau.pixkey.core.domain.AccountType;

import java.util.Optional;

public interface AccountGateway {

    Account insert(Account account);
    Optional<Account> search(final AccountType accountType, final Integer agency, final Integer accountNumber);
    Boolean exists(final Integer agency, final Integer accountNumber);

}
