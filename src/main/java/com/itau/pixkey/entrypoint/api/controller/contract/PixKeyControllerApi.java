package com.itau.pixkey.entrypoint.api.controller.contract;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyWithDatesDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.PixKeyInput;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/pix-key")
public interface PixKeyControllerApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PixKeyDTO insert(@RequestBody @Valid final PixKeyInput pixKeyInput);

    @PutMapping("/{id}/inactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void inactivate(@PathVariable final UUID id);

    @GetMapping("/{id}")
    PixKeyWithDatesDTO searchById(@PathVariable final UUID id);

    @GetMapping
    List<PixKeyWithDatesDTO> searchBy(@RequestParam final KeyType keyType, @RequestParam final Integer agency, @RequestParam final Integer accountNumber,
        @RequestParam final String holderName, @RequestParam final OffsetDateTime registrationDate, @RequestParam final OffsetDateTime inactivationDate);

}
