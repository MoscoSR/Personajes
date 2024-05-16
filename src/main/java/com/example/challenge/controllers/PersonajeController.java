package com.example.challenge.controllers;

import com.example.challenge.models.DTO.PersonajeDTO;
import com.example.challenge.service.PersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personaje")
@CrossOrigin("*")
public class PersonajeController {

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    /*EndPoints para interactuar con los personajes*/
    @PostMapping("/")
    @Operation(summary = "Crear un nuevo personaje")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Personaje creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public ResponseEntity<?> createPersonaje(@RequestBody PersonajeDTO personajeDTO) {
     return new ResponseEntity<>(personajeService.createPersonaje(personajeDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los personajes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Lista de personajes"),
            @ApiResponse(responseCode = "400", description = "No se encontraron personajes")
    })
    @GetMapping("/")
    public ResponseEntity<?>getPersonajes() {
        return new ResponseEntity<>(personajeService.getPersonajes(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un personaje por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200", description = "Personaje encontrado"),
            @ApiResponse(responseCode = "404", description = "Personaje no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?>getPersonaje(@PathVariable Long id) {
        return new ResponseEntity<>(personajeService.getPersonaje(id), HttpStatus.ACCEPTED);
    }


    @Operation(summary = "Actualizar un personaje")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Personaje actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Personaje no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?>updatePersonaje(@PathVariable Long id, @RequestBody PersonajeDTO personajeDTO) {
        return new ResponseEntity<>(personajeService.updatePersonaje(id, personajeDTO), HttpStatus.ACCEPTED);
    }


    @Operation(description = "Eliminar un personaje")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "204", description = "Personaje eliminado"),
            @ApiResponse(responseCode = "404", description = "Personaje no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletePersonaje(@PathVariable Long id) {
        personajeService.deletePersonaje(id);
        return ResponseEntity.accepted().build();
    }
}
