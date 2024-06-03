package com.itau.pixkey.entrypoint.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@JsonInclude(NON_NULL)
public class ErrorResponse {

    private Integer status;
    private String title;
    private String path;
    private OffsetDateTime timestamp;
    private List<Details> details;

    public static ErrorResponse of(Integer httpStatus, String path, String title) {
        return ErrorResponse
                .builder()
                .status(httpStatus)
                .title(title)
                .path(path)
                .timestamp(OffsetDateTime.now())
                .build();
    }

    public static ErrorResponse of(Integer httpStatus, String path, String title, List<Details> details) {
        return ErrorResponse
                .builder()
                .status(httpStatus)
                .title(title)
                .path(path)
                .timestamp(OffsetDateTime.now())
                .details(details)
                .build();
    }

}
