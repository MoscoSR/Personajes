package com.example.challenge.service;
import com.example.challenge.mapper.PersonajeMapper;
import com.example.challenge.models.DTO.PersonajeDTO;
import com.example.challenge.models.PersonajeEntity;
import com.example.challenge.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PersonajeService {
    @Autowired
    private final PersonajeRepository personajeRepository;
    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository, PersonajeMapper personajeMapper) {
        this.personajeRepository = personajeRepository;
        this.personajeMapper = personajeMapper;
    }

    public List<PersonajeDTO> getPersonajes() {
        List<PersonajeEntity> personajeEntities = personajeRepository.findAll();
        return personajeEntities.stream()
                .map(personajeMapper::convert)
                .collect(Collectors.toList());
    }

    public PersonajeDTO getPersonaje(Long id) {
        Optional<PersonajeEntity> optionalPersonaje = personajeRepository.findById(id);
        if (optionalPersonaje.isPresent()) {
            return personajeMapper.convert(optionalPersonaje.get());
        } else {
            throw new NoSuchElementException("Personaje No Encontrado");
        }
    }

    public PersonajeDTO createPersonaje(PersonajeDTO personajeDTO) {

        PersonajeEntity personajeEntity = personajeMapper.convertDTO(personajeDTO);
        PersonajeEntity savedPersonajeEntity = personajeRepository.save(personajeEntity);
        return personajeMapper.convert(savedPersonajeEntity);
    }

    public PersonajeDTO updatePersonaje(Long id, PersonajeDTO personajeDTO) {
        Optional<PersonajeEntity> optionalPersonajeEntity = personajeRepository.findById(id);
        if (optionalPersonajeEntity.isPresent()) {
            PersonajeEntity personajeEntity = optionalPersonajeEntity.get();
            personajeEntity.setNombre(personajeDTO.getNombre());
            personajeEntity.setNivelDePoder(personajeDTO.getNivelDePoder());
            personajeEntity.setDescription(personajeDTO.getDescription());
            personajeEntity.setImagenUrl(personajeDTO.getImagenUrl());
            PersonajeEntity updatedPersonajeEntity = personajeRepository.save(personajeEntity);
            return personajeMapper.convert(updatedPersonajeEntity);
        } else {
            throw new NoSuchElementException("Personaje no encontrado con ID: " + id);
        }
    }

    public void deletePersonaje(Long id) {
        Optional<PersonajeEntity> optionalPersonajeEntity = personajeRepository.findById(id);
        if (optionalPersonajeEntity.isPresent()) {
            personajeRepository.delete(optionalPersonajeEntity.get());
        } else {
            throw new NoSuchElementException("Personaje no encontrado con ID: " + id);
        }
    }
}
