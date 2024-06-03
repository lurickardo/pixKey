package com.itau.pixkey.entrypoint.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@JsonInclude(NON_NULL)
public class Details {

    private String name;
    private String message;

    public static Details of(String name, String message) {
        return Details
                .builder()
                .name(name)
                .message(message)
                .build();
    }

}
