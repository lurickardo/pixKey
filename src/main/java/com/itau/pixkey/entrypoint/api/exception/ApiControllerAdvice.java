package com.itau.pixkey.entrypoint.api.exception;

import com.itau.pixkey.core.exception.BusinessException;
import com.itau.pixkey.core.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.List;

@ControllerAdvice
public class ApiControllerAdvice {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex, ServletWebRequest request) {
        var httpStatus = HttpStatus.NOT_FOUND.value();
        var path = request.getRequest().getRequestURI();
        return ResponseEntity.status(httpStatus).body(ErrorResponse.of(httpStatus, path, ex.getMessage()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex, ServletWebRequest request) {
        var httpStatus = HttpStatus.BAD_REQUEST.value();
        var path = request.getRequest().getRequestURI();
        return ResponseEntity.badRequest().body(ErrorResponse.of(httpStatus, path, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, ServletWebRequest request) {
        var title = "Input data is incorrect";
        var httpStatus = HttpStatus.BAD_REQUEST.value();

        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();

        var details = objectErrors.stream()
                .map(objectError -> {

                    var name = objectError.getObjectName();
                    var message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());

                    if (objectError instanceof FieldError) {
                        name = ((FieldError) objectError).getField();
                    }

                    return Details.of(name, message);
                })
                .toList();

        var path = request.getRequest().getRequestURI();
        var errorResponse = ErrorResponse.of(httpStatus, path, title, details);
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
