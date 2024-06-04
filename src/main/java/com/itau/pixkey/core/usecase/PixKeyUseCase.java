package com.itau.pixkey.core.usecase;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.PersonCategory;
import com.itau.pixkey.core.domain.PixKey;
import com.itau.pixkey.core.exception.AccountWithThisCheckingNotFoundException;
import com.itau.pixkey.core.exception.BusinessException;
import com.itau.pixkey.core.exception.PixKeyNotFoundException;
import com.itau.pixkey.core.gateway.PixKeyGateway;
import com.itau.pixkey.core.usecase.createpixkeypersoncategory.CreatePixKeyPersonCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PixKeyUseCase {

    private final AccountUseCase accountUseCase;
    private final Map<PersonCategory, CreatePixKeyPersonCategory> createPixKeyPersonCategoryMap;
    private final PixKeyGateway pixKeyGateway;

    public PixKey insert(final PixKey pixKey) {
        try {
            var account = accountUseCase.searchCheckingAccountById(pixKey.getAccount().getId());
            return createPixKeyPersonCategoryMap.get(account.getPersonCategory()).insert(account, pixKey);
        } catch (AccountWithThisCheckingNotFoundException ex) {
            throw new BusinessException(ex.getMessage(), ex);
        }
    }

    public void inactivate(final UUID id) {
        searchById(id).inactivate();
    }

    public PixKey searchById(final UUID id) {
        return pixKeyGateway.searchById(id).orElseThrow(() -> new PixKeyNotFoundException(id));
    }

    public List<PixKey> searchBy(final KeyType keyType, final Integer agency, final Integer accountNumber,final String holderName, final OffsetDateTime registrationDate, final OffsetDateTime inactivationDate) {
        return pixKeyGateway.searchBy(keyType, agency, accountNumber, holderName, registrationDate, inactivationDate);
    }

}
