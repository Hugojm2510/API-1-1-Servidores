package com.vedruna.api1_1_reinicio.dto;

import com.vedruna.api1_1_reinicio.persistance.models.Contacto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactoDTO {
    
    private Long idContacto;
    private String direccion;
    private String telefono;
    private Long alumnos_idalumno;

    public ContactoDTO(Contacto contacto){
        this.idContacto = contacto.getIdContacto();
        this.direccion = contacto.getDireccion();
        this.telefono = contacto.getTelefono();
        this.alumnos_idalumno = contacto.getAlumno().getAlumnoId();
    }
}