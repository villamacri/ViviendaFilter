package com.salesianostriana.dam.viviendafilter.repository;

import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ViviendaRepository extends JpaRepository<Vivienda, Long>,
        JpaSpecificationExecutor<Vivienda> {

    @Query("select v from Vivienda v where v.ciudad = :ciudad")
    Optional<Vivienda> findByCiudad(String ciudad);

}
