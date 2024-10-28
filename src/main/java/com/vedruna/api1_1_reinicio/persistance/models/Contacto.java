package com.vedruna.api1_1_reinicio.persistance.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="infocontacto")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contacto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idinfocontacto", nullable = false)
    private Long idContacto;
    
    @Column(name="direccion")
    private String direccion;

    @Column(name="telefono", nullable = false)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "alumnos_idalumno", referencedColumnName = "idalumno")
    private Alumno alumno;
}
