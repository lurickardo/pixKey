package com.itau.pixkey.core.gateway;

public interface ValidatorGateway {

    Boolean cpfIsValid(String cpf);
    Boolean cnpjIsValid(String cnpj);

}
