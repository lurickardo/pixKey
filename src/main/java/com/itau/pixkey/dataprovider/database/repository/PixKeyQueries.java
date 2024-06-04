package com.itau.pixkey.dataprovider.database.repository;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.PixKey;

import java.time.OffsetDateTime;
import java.util.List;

public interface PixKeyQueries {

    List<PixKey> findBy(final KeyType keyType, final Integer agency, final Integer accountNumber, final String holderName, final OffsetDateTime registrationDate, final OffsetDateTime inactivationDate);

}
