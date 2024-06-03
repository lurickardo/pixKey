package com.itau.pixkey.entrypoint.api.controller.mapper;

import com.itau.pixkey.core.domain.PixKey;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.PixKeyInput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PixKeyMapper {

    private final ModelMapper modelMapper;

    public PixKey toDomainObject(final PixKeyInput pixKeyInput) {
        return modelMapper.map(pixKeyInput, PixKey.class);
    }

    public PixKeyDTO toResponse(final PixKey pixKey) {
        return modelMapper.map(pixKey, PixKeyDTO.class);
    }

}
