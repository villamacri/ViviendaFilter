package com.salesianostriana.dam.viviendafilter.controller;

import com.salesianostriana.dam.viviendafilter.dto.ViviendaRequest;
import com.salesianostriana.dam.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import com.salesianostriana.dam.viviendafilter.service.ViviendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/viviendas")
@RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService viviendaService;

    @PostMapping
    public ResponseEntity<Vivienda> create(@Valid @RequestBody ViviendaRequest dto){
        Vivienda nuevaVivienda = viviendaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVivienda);
    }

    @GetMapping
    public ResponseEntity<Page<ViviendaResponse>> getAllPage(
            @RequestParam (required = false) String ciudad,
            @RequestParam (required = false) String provincia,
            @RequestParam (required = false) Double precioMin,
            @RequestParam (required = false) Double precioMax,
            @RequestParam (required = false) Integer numHab,
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "fechaPublicacion",
                    direction = Sort.Direction.DESC) Pageable pageable){
        return  ResponseEntity.ok(viviendaService.findViviendasPage(ciudad, provincia, precioMin, precioMax, numHab, pageable));
    }

}
