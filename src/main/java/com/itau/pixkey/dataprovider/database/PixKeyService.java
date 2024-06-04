package com.itau.pixkey.dataprovider.database;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.PixKey;
import com.itau.pixkey.core.gateway.PixKeyGateway;
import com.itau.pixkey.dataprovider.database.repository.PixKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PixKeyService implements PixKeyGateway {

    private final PixKeyRepository pixKeyRepository;

    @Override
    public Boolean existsByKeyValue(final String keyValue,final KeyType keyType) {
        return pixKeyRepository.existsByKeyValueAndKeyType(keyValue, keyType);
    }

    @Override
    public Optional<PixKey> searchById(final UUID id) {
        return pixKeyRepository.findById(id);
    }

    @Override
    public List<PixKey> searchBy(KeyType keyType, Integer agency, Integer accountNumber, String holderName, OffsetDateTime registrationDate, OffsetDateTime inactivationDate) {
        return pixKeyRepository.findBy(keyType, agency, accountNumber, holderName, registrationDate, inactivationDate);
    }

}
