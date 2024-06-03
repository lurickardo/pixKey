package com.itau.pixkey.dataprovider.database.repository;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PixKeyRepository extends JpaRepository<PixKey, UUID> {

    Boolean existsByKeyValueAndKeyType(String keyValue, KeyType keyType);

}
