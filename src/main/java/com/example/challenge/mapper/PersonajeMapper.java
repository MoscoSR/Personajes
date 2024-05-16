package com.example.challenge.mapper;

import com.example.challenge.models.DTO.PersonajeDTO;
import com.example.challenge.models.PersonajeEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonajeMapper implements Converter<PersonajeEntity, PersonajeDTO> {

    @Override
    public PersonajeDTO convert(PersonajeEntity personajeEntity) {
        return PersonajeDTO.builder()
                .id(personajeEntity.getId())
                .nombre(personajeEntity.getNombre())
                .nivelDePoder(personajeEntity.getNivelDePoder())
                .description(personajeEntity.getDescription())
                .imagenUrl(personajeEntity.getImagenUrl())
                .build();
    }

    public PersonajeEntity convertDTO(PersonajeDTO personajeDTO) {
        return PersonajeEntity.builder()
                .id(personajeDTO.getId())
                .nombre(personajeDTO.getNombre())
                .nivelDePoder(personajeDTO.getNivelDePoder())
                .description(personajeDTO.getDescription())
                .imagenUrl(personajeDTO.getImagenUrl())
                .build();
    }
}
