package com.example.challenge.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDTO {
    private Long id;
    private String nombre;
    private Double nivelDePoder;
    private String description;
    private String imagenUrl;
}
