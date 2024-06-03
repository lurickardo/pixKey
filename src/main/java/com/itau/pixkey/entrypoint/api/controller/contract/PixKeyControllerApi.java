package com.itau.pixkey.entrypoint.api.controller.contract;

import com.itau.pixkey.entrypoint.api.controller.payload.PixKeyDTO;
import com.itau.pixkey.entrypoint.api.controller.payload.input.PixKeyInput;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/agency/{agency}/account-number/{accountNumber}/pix-key")
public interface PixKeyControllerApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PixKeyDTO insert(@PathVariable final Integer agency, @PathVariable final Integer accountNumber, @RequestBody @Valid final PixKeyInput pixKeyInput);

}
