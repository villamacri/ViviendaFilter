package com.salesianostriana.dam.viviendafilter.service;

import com.salesianostriana.dam.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.dam.viviendafilter.errors.ViviendaNotFoundException;
import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import com.salesianostriana.dam.viviendafilter.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
