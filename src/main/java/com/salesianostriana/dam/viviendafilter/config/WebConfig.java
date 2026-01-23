package com.salesianostriana.dam.viviendafilter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

//Anotaciones del Sergio para que el json del page se vea mas agradable (gracias)
@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class WebConfig {
}
