package com.itau.pixkey.core.config;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.domain.PersonCategory;
import com.itau.pixkey.core.usecase.createpixkeypersoncategory.CreatePixKeyPF;
import com.itau.pixkey.core.usecase.createpixkeypersoncategory.CreatePixKeyPJ;
import com.itau.pixkey.core.usecase.createpixkeypersoncategory.CreatePixKeyPersonCategory;
import com.itau.pixkey.core.validation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

import static com.itau.pixkey.core.domain.PersonCategory.PF;
import static com.itau.pixkey.core.domain.PersonCategory.PJ;

@Configuration
public class MapConfig {

    @Bean
    public Map<PersonCategory, CreatePixKeyPersonCategory> createPixKeyPersonCategoryMap(CreatePixKeyPF createPixKeyPF, CreatePixKeyPJ createPixKeyPJ) {
        EnumMap<PersonCategory, CreatePixKeyPersonCategory> createPixKeyPersonCategoryMap = new EnumMap<>(PersonCategory.class);
        createPixKeyPersonCategoryMap.put(PF, createPixKeyPF);
        createPixKeyPersonCategoryMap.put(PJ, createPixKeyPJ);

        return createPixKeyPersonCategoryMap;
    }

    @Bean
    public Map<KeyType, PixKeyValidation> pixKeyValidationMap(CellPhoneValidation cellPhoneValidation, CNPJValidation cnpjValidation,
                                                              CPFValidation cpfValidation, EmailValidation emailValidation, RandomKeyValidation randomKeyValidation) {
        EnumMap<KeyType, PixKeyValidation> pixKeyValidationMap = new EnumMap<>(KeyType.class);
        pixKeyValidationMap.put(KeyType.CELL_PHONE, cellPhoneValidation);
        pixKeyValidationMap.put(KeyType.CNPJ, cnpjValidation);
        pixKeyValidationMap.put(KeyType.CPF, cpfValidation);
        pixKeyValidationMap.put(KeyType.EMAIL, emailValidation);
        pixKeyValidationMap.put(KeyType.RANDOM, randomKeyValidation);

        return pixKeyValidationMap;
    }

}
