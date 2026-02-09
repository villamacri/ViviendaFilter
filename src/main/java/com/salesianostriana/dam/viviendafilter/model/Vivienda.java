package com.salesianostriana.dam.viviendafilter.model;

import com.salesianostriana.dam.viviendafilter.enums.EstadoVivienda;
import com.salesianostriana.dam.viviendafilter.enums.TipoVivienda;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "viviendas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Vivienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(length = 2000)
    private String descripcion;

    @Column(nullable = false, length = 80)
    private String ciudad;

    @Column(nullable = false, length = 80)
    private String provincia;

    @Column(nullable = false)
    private Integer precio;

    @Column(name = "metros_cuadrados",nullable = false)
    private Integer metrosCuadrados;

    @Column(nullable = false)
    private Integer habitaciones;

    @Column(nullable = false)
    private Integer banos;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;

    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;

    @Column(nullable = false)
    private Boolean ascensor;

    @Column(nullable = false)
    private Boolean terraza;

    @Column(nullable = false)
    private Boolean garaje;

    @Column(nullable = false)
    private Boolean disponible;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;
}
