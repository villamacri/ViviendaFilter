package com.salesianostriana.dam.viviendafilter.spec;

import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.util.function.Predicate;

public class ViviendaSpecifications {

    public static PredicateSpecification<Vivienda> hasCiudad(String ciudad){
        return (from, criteriaBuilder) -> ciudad == null ? null :
                criteriaBuilder.equal(from.get("ciudad"),ciudad);
    }

    public static PredicateSpecification<Vivienda> hasProvincia(String provincia){
        return (from, criteriaBuilder) -> provincia == null ? null :
                criteriaBuilder.equal(from.get("provincia"),provincia);
    }

    public static PredicateSpecification<Vivienda> precioMayorQueMin(Double precioMin){
        return (from, criteriaBuilder) -> precioMin == null ? null :
                criteriaBuilder.greaterThanOrEqualTo(from.get("precio"), precioMin);
    }

    public static PredicateSpecification<Vivienda> precioMenorQueMax(Double precioMax){
        return (from, criteriaBuilder) -> precioMax == null ? null :
                criteriaBuilder.lessThanOrEqualTo(from.get("precio"), precioMax);
    }

    public static PredicateSpecification<Vivienda> habitacionesMin(Integer habMin){
        return (from, criteriaBuilder) -> habMin == null ? null :
                criteriaBuilder.greaterThanOrEqualTo(from.get("habitaciones"), habMin);
    }
}
