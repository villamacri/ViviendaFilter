package com.salesianostriana.dam.viviendafilter.anotaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.time.LocalDateTime;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeBetweenValidator.class)
@Documented
public @interface DateTimeBetween {

    String message() default "El nombre del producto ya esta registrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String min();
    String max();

    @Target()
}
