package com.salesianostriana.dam.viviendafilter.controller;

import com.salesianostriana.dam.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import com.salesianostriana.dam.viviendafilter.service.ViviendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/viviendas")
@RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping
    public Page<ViviendaResponse> getAllPage(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "fechaPublicacion",
                    direction = Sort.Direction.DESC) Pageable pageable){
        return  viviendaService.findViviendasPage(pageable);
    }

    public ResponseEntity<List<Vivienda>> getViviendas(
            @RequestParam (required = false) String ciudad,
            @RequestParam (required = false) String provincia,
            @RequestParam (required = false) Double precioMin,
            @RequestParam (required = false) Double precioMax,
            @RequestParam (required = false) Integer numHab
    ){
        return ResponseEntity.ok(viviendaService.buscarViviendas(ciudad, provincia, precioMin, precioMax, numHab));
    }
}
