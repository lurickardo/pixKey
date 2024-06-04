package com.itau.pixkey.dataprovider.database.repository;

import com.itau.pixkey.core.domain.Account;
import com.itau.pixkey.core.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByAccountTypeAndId(AccountType accountType, UUID id);
    Boolean existsByAgencyAndAccountNumber(Integer agency, Integer accountNumber);

}
