package com.salesianostriana.dam.viviendafilter.anotaciones;

import jakarta.validation.ConstraintValidator;

import java.time.LocalDateTime;

public class DateTimeBetweenValidator implements ConstraintValidator<DateTimeBetween, LocalDateTime> {

    private String strMinData, strMaxData;


}
