package com.itau.pixkey.entrypoint.libraries.config;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StellaConfig {

    @Bean
    public CPFValidator stellaCpfValidator() {
        return new CPFValidator();
    }

    @Bean
    public CNPJValidator stellaCnpjValidator() {
        return new CNPJValidator();
    }

}
