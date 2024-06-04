package com.itau.pixkey.entrypoint.libraries;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import com.itau.pixkey.core.gateway.ValidatorGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Component
@RequiredArgsConstructor
public class StellaService implements ValidatorGateway {

    private final CPFValidator cpfValidator;
    private final CNPJValidator cnpjValidator;

    public Boolean cpfIsValid(String cpf) {
        try {
            cpfValidator.assertValid(cpf);
            return TRUE;
        } catch (Exception e) {
            return FALSE;
        }
    }

    public Boolean cnpjIsValid(String cnpj) {
        try {
            cnpjValidator.assertValid(cnpj);
            return TRUE;
        } catch (Exception e) {
            return FALSE;
        }
    }

}
