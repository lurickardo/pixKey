package com.itau.pixkey.dataprovider.database;

import com.itau.pixkey.core.domain.Account;
import com.itau.pixkey.core.domain.AccountType;
import com.itau.pixkey.core.gateway.AccountGateway;
import com.itau.pixkey.dataprovider.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountGateway {

    private final AccountRepository accountRepository;

    @Override
    public Account insert(final Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> searchCheckingAccountById(final AccountType accountType, final UUID accountId) {
        return accountRepository.findByAccountTypeAndId(accountType, accountId);
    }

    @Override
    public Boolean exists(final Integer agency, final Integer accountNumber) {
        return accountRepository.existsByAgencyAndAccountNumber(agency, accountNumber);
    }

}
