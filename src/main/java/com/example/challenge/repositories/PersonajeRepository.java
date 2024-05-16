package com.example.challenge.repositories;

import com.example.challenge.models.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {

}
