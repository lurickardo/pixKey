package com.itau.pixkey.core.usecase.createpixkeypersoncategory;

import com.itau.pixkey.core.gateway.PixKeyGateway;
import com.itau.pixkey.core.usecase.AccountUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreatePixKeyPJ extends CreatePixKeyPersonCategory {

    public CreatePixKeyPJ(final AccountUseCase accountUseCase, final PixKeyGateway pixKeyGateway) {
        super(accountUseCase, pixKeyGateway);
    }

    @Override
    public Integer getMaximumNumberOfPixKeys() {
        return 20;
    }

}
