package com.itau.pixkey.dataprovider.database;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.gateway.PixKeyGateway;
import com.itau.pixkey.dataprovider.database.repository.PixKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixKeyService implements PixKeyGateway {

    private final PixKeyRepository pixKeyRepository;

    @Override
    public Boolean existsByKeyValue(final String keyValue,final KeyType keyType) {
        return pixKeyRepository.existsByKeyValueAndKeyType(keyValue, keyType);
    }

}
