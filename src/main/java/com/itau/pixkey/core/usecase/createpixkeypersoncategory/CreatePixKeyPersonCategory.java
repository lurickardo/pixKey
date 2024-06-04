package com.itau.pixkey.core.usecase.createpixkeypersoncategory;

import com.itau.pixkey.core.domain.Account;
import com.itau.pixkey.core.domain.PixKey;
import com.itau.pixkey.core.exception.ExistsKeyValueException;
import com.itau.pixkey.core.exception.MaximumNumberOfPixKeysException;
import com.itau.pixkey.core.gateway.PixKeyGateway;
import com.itau.pixkey.core.usecase.AccountUseCase;

public abstract class CreatePixKeyPersonCategory {

    private final AccountUseCase accountUseCase;
    private final PixKeyGateway pixKeyGateway;

    protected CreatePixKeyPersonCategory(final AccountUseCase accountUseCase, final PixKeyGateway pixKeyGateway) {
        this.accountUseCase = accountUseCase;
        this.pixKeyGateway = pixKeyGateway;
    }

    public PixKey insert(Account account, PixKey pixKey) {
        if (account.getNumberOfPixKeys() >= getMaximumNumberOfPixKeys()) {
            throw new MaximumNumberOfPixKeysException();
        }

        if (pixKeyGateway.existsByKeyValue(pixKey.getKeyValue(), pixKey.getKeyType())) {
            throw new ExistsKeyValueException(pixKey.getKeyValue());
        }

        account.addPixKey(pixKey);
        return accountUseCase.update(account).getLastPixKey();
    }

    public abstract Integer getMaximumNumberOfPixKeys();

}
