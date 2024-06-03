package com.itau.pixkey.core.usecase;

import com.itau.pixkey.core.domain.PersonCategory;
import com.itau.pixkey.core.domain.PixKey;
import com.itau.pixkey.core.usecase.createpixkeypersoncategory.CreatePixKeyPersonCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PixKeyUseCase {

    private final AccountUseCase accountUseCase;
    private final Map<PersonCategory, CreatePixKeyPersonCategory> createPixKeyPersonCategoryMap;

    public PixKey insert(final Integer agency, final Integer accountNumber, final PixKey pixKey) {
        var account = accountUseCase.searchCheckingAccount(agency, accountNumber);
        return createPixKeyPersonCategoryMap.get(account.getPersonCategory()).insert(account, pixKey);
    }

}
