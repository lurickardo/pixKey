package com.itau.pixkey.core.gateway;

import com.itau.pixkey.core.domain.KeyType;

public interface PixKeyGateway {

    Boolean existsByKeyValue(final String keyValue, final KeyType keyType);

}
