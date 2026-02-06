package com.salesianostriana.dam.viviendafilter.dto;

import com.salesianostriana.dam.viviendafilter.enums.TipoVivienda;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ViviendaRequest(
        @NotBlank(message = "{viviendaRequest.titulo.notblank}")
        String titulo,
        String descripcion,
        @NotBlank(message = "{viviendaRequest.ciudad.notblank}")
        String ciudad,
        @NotBlank(message = "{viviendaRequest.provincia.notblank}")
        String provincia,
        @NotNull(message = "{viviendaRequest.precio.notnull}")
        @Min(value = 1, message = "{viviendaRequest.precio.min}")
        Integer precio,
        @NotNull(message = "{viviendaRequest.metrosCuadrados.notnull}")
        @Min(value = 1, message = "{viviendaRequest.metrosCuadrados.min}")
        Integer metrosCuadrados,
        @NotNull(message = "{viviendaRequest.habitaciones.notnull}")
        @Min(value = 0, message = "{viviendaRequest.habitaciones.min}")
        Integer habitaciones,
        @NotNull(message = "{viviendaRequest.banos.notnull}")
        @Min(value = 1, message = "{viviendaRequest.banos.min}")
        Integer banos,
        @NotNull(message = "{viviendaRequest.tipo.notnull}")
        TipoVivienda tipo
) {
}
