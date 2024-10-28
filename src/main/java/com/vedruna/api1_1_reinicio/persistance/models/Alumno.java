package com.vedruna.api1_1_reinicio.persistance.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="alumnos")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alumno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumno", nullable = false)
    private Long alumnoId;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellidos", nullable = false)
    private String apellidos;

    @OneToOne(mappedBy = "alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Contacto contacto;
}
