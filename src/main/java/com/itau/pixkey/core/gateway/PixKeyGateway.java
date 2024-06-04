package com.itau.pixkey.core.gateway;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.PixKey;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PixKeyGateway {

    Boolean existsByKeyValue(final String keyValue, final KeyType keyType);
    Optional<PixKey> searchById(final UUID id);
    List<PixKey> searchBy(final KeyType keyType, final Integer agency, final Integer accountNumber, final String holderName, final OffsetDateTime registrationDate, final OffsetDateTime inactivationDate);

}
