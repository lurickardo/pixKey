package com.itau.pixkey.entrypoint.api.controller;

import com.itau.pixkey.core.usecase.PixKeyUseCase;
import com.itau.pixkey.entrypoint.api.controller.contract.PixKeyControllerApi;
import com.itau.pixkey.entrypoint.api.controller.mapper.PixKeyMapper;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.PixKeyInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

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
    public PixKeyDTO insert(final Integer agency, final Integer accountNumber, final PixKeyInput pixKeyInput) {
        var pixKey = pixKeyUseCase.insert(agency, accountNumber, pixKeyMapper.toDomainObject(pixKeyInput));
        return pixKeyMapper.toResponse(pixKey);
    }

}
