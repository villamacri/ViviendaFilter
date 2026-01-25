package com.salesianostriana.dam.viviendafilter.service;

import com.salesianostriana.dam.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.dam.viviendafilter.errors.ViviendaNotFoundException;
import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import com.salesianostriana.dam.viviendafilter.repository.ViviendaRepository;
import com.salesianostriana.dam.viviendafilter.spec.ViviendaSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Page<ViviendaResponse> findViviendasPage(Pageable pageable){

        Page<Vivienda> result = viviendaRepository.findAll(pageable);

        if(result.isEmpty()){
            throw new ViviendaNotFoundException("No hay viviendas");
        }

        return result.map(ViviendaResponse::of);
    }

    public List<Vivienda> buscarViviendas(
            String ciudad,
            String provincia,
            Double precioMin,
            Double precioMax,
            Integer numHab){
        Specification<Vivienda> spec= Specification
                .where(ViviendaSpecifications.hasCiudad(ciudad))
                .and(ViviendaSpecifications.hasProvincia(provincia))
                .and(ViviendaSpecifications.precioMayorQueMin(precioMin))
                .and(ViviendaSpecifications.precioMenorQueMax(precioMax))
                .and(ViviendaSpecifications.habitacionesMin(numHab));

        return viviendaRepository.findAll(spec);
    }

}
