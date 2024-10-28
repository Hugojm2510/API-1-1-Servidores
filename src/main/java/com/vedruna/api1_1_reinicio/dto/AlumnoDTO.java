package com.vedruna.api1_1_reinicio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vedruna.api1_1_reinicio.persistance.models.Alumno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlumnoDTO {
    
    private Long alumnoId;
    private String nombre;
    private String apellidos;
    private ContactoDTO contacto;

    public AlumnoDTO(Alumno alumno){
        this.alumnoId = alumno.getAlumnoId();
        this.nombre = alumno.getNombre();
        this.apellidos = alumno.getApellidos();
    }
}
