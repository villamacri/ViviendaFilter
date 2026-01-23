package com.salesianostriana.dam.viviendafilter.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ViviendaNotFoundException.class)
    public ProblemDetail handleViviendaNotFound(ViviendaNotFoundException ex){
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        detail.setTitle("Entidad no encontrada");

        return detail;
    }
}
