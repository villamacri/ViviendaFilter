package com.salesianostriana.dam.viviendafilter.model;

import com.salesianostriana.dam.viviendafilter.enums.EstadoVivienda;
import com.salesianostriana.dam.viviendafilter.enums.TipoVivienda;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Vivienda {
    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private String descripcion;
    private String ciudad;
    private String provincia;
    private Integer precio;
    private Integer metrosCuadrados;
    private Integer habitaciones;
    private Integer banos;
    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;
    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;
    private Boolean ascensor;
    private Boolean terraza;
    private Boolean garaje;
    private Boolean disponible;
    private LocalDate fechaPublicacion;
}
