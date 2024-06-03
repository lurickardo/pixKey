package com.itau.pixkey.dataprovider.database;

import com.itau.pixkey.core.domain.Account;
import com.itau.pixkey.core.domain.AccountType;
import com.itau.pixkey.core.gateway.AccountGateway;
import com.itau.pixkey.dataprovider.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountGateway {

    private final AccountRepository accountRepository;

    @Override
    public Account insert(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> search(final AccountType accountType, final Integer agency, final Integer accountNumber) {
        return accountRepository.findByAccountTypeAndAgencyAndAccountNumber(accountType, agency, accountNumber);
    }

    @Override
    public Boolean exists(final Integer agency, final Integer accountNumber) {
        return accountRepository.existsByAgencyAndAccountNumber(agency, accountNumber);
    }

}
