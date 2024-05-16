package com.example.challenge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String nombre;
    private Double nivelDePoder;
    private String description;
    private String imagenUrl;

}
