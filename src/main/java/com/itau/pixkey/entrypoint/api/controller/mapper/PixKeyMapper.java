package com.itau.pixkey.entrypoint.api.controller.mapper;

import com.itau.pixkey.core.domain.PixKey;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyWithDatesDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.PixKeyInput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public PixKeyWithDatesDTO toResponseWithDates(final PixKey pixKey) {
        return modelMapper.map(pixKey, PixKeyWithDatesDTO.class);
    }

    public List<PixKeyWithDatesDTO> toCollectionResponseWithDates(final List<PixKey> pixKeys) {
        return pixKeys.stream().map(this::toResponseWithDates).toList();
    }

}
