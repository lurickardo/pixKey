package com.itau.pixkey.entrypoint.api.controller;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.usecase.PixKeyUseCase;
import com.itau.pixkey.entrypoint.api.controller.contract.PixKeyControllerApi;
import com.itau.pixkey.entrypoint.api.controller.mapper.PixKeyMapper;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyWithDatesDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.PixKeyInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "PixKeyController", description = "Manage the pix key")
public class PixKeyController implements PixKeyControllerApi {

    private final PixKeyUseCase pixKeyUseCase;
    private final PixKeyMapper pixKeyMapper;

    @Operation(summary = "Create a pix key")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "create a pix key with successful")
    })
    @Override
    public PixKeyDTO insert(final PixKeyInput pixKeyInput) {
        var pixKey = pixKeyUseCase.insert(pixKeyMapper.toDomainObject(pixKeyInput));
        return pixKeyMapper.toResponse(pixKey);
    }

    @Override
    public void inactivate(UUID id) {
        pixKeyUseCase.inactivate(id);
    }

    @Override
    public PixKeyWithDatesDTO searchById(final UUID id) {
        var pixKey = pixKeyUseCase.searchById(id);
        return pixKeyMapper.toResponseWithDates(pixKey);
    }

    @Override
    public List<PixKeyWithDatesDTO> searchBy(final KeyType keyType, final Integer agency, final Integer accountNumber, final String holderName, final OffsetDateTime registrationDate, final OffsetDateTime inactivationDate) {
        var pixKeys = pixKeyUseCase.searchBy(keyType, agency, accountNumber, holderName, registrationDate, inactivationDate);
        return pixKeyMapper.toCollectionResponseWithDates(pixKeys);
    }

}
