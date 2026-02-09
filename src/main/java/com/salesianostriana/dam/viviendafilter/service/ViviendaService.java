package com.salesianostriana.dam.viviendafilter.service;

import com.salesianostriana.dam.viviendafilter.dto.ViviendaRequest;
import com.salesianostriana.dam.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.dam.viviendafilter.errors.ViviendaNotFoundException;
import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import com.salesianostriana.dam.viviendafilter.repository.ViviendaRepository;
import com.salesianostriana.dam.viviendafilter.spec.ViviendaSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Vivienda create(ViviendaRequest dto){

        if(dto.precio() > 1000000){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Precio fuera de rango");
        }

        if(dto.metrosCuadrados() > 1000){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Metros cuadrados fuera de rango");
        }

        Vivienda vivienda = Vivienda.builder()
                .titulo(dto.titulo())
                .descripcion(dto.descripcion())
                .ciudad(dto.ciudad())
                .provincia(dto.provincia())
                .precio(dto.precio())
                .metrosCuadrados(dto.metrosCuadrados())
                .habitaciones(dto.habitaciones())
                .banos(dto.banos())
                .tipo(dto.tipo())
                .estado(dto.estado())
                .ascensor(dto.ascensor())
                .terraza(dto.terraza())
                .garaje(dto.garaje())
                .disponible(dto.disponible())
                .fechaPublicacion(LocalDate.now())
                .build();



        return viviendaRepository.save(vivienda);
    }

    public Page<ViviendaResponse> findViviendasPage(
            String ciudad,
            String provincia,
            Double precioMin,
            Double precioMax,
            Integer numHab,
            Pageable pageable){
        Specification<Vivienda> spec= Specification
                .where(ViviendaSpecifications.hasCiudad(ciudad))
                .and(ViviendaSpecifications.hasProvincia(provincia))
                .and(ViviendaSpecifications.precioMayorQueMin(precioMin))
                .and(ViviendaSpecifications.precioMenorQueMax(precioMax))
                .and(ViviendaSpecifications.habitacionesMin(numHab));

        Page<Vivienda> result = viviendaRepository.findAll(spec, pageable);

        if(result.isEmpty()){
            throw new ViviendaNotFoundException("No hay viviendas");
        }

        return result.map(ViviendaResponse::of);
    }

}
