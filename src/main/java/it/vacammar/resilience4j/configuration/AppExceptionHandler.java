package it.vacammar.resilience4j.configuration;

import it.vacammar.resilience4j.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> globalExceptionHandler(Exception ex, WebRequest request) {
        return new ResponseEntity<ApiResponse<String>>(
                ApiResponse.Builder.anApiResponse()
                        .withSuccess(false)
                        .withMessage(ex.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}