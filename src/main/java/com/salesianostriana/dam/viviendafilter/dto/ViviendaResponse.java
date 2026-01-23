package com.salesianostriana.dam.viviendafilter.dto;

import com.salesianostriana.dam.viviendafilter.enums.EstadoVivienda;
import com.salesianostriana.dam.viviendafilter.enums.TipoVivienda;

import java.time.LocalDate;

public record ViviendaResponse(
    Long id,
    String titulo,
    String ciudad,
    String provincia,
    Integer precio,
    Integer metrosCuadrados,
    Integer habitaciones,
    Integer banos,
    TipoVivienda tipo,
    EstadoVivienda estado,
    Boolean disponible,
    LocalDate fechaPublicacion
) {

}
