package com.vedruna.api1_1_reinicio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.api1_1_reinicio.dto.AlumnoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Alumno;
import com.vedruna.api1_1_reinicio.persistance.models.Contacto;
import com.vedruna.api1_1_reinicio.persistance.repository.AlumnoRepositoryI;

@Service
public class AlumnoServiceImpI implements AlumnoServiceI{
    
    @Autowired
    AlumnoRepositoryI alRepo;

    @Override
    public List<Alumno> getAllAlumnos(){
        return alRepo.findAll();
    }

    @Override
    public List<AlumnoDTO> getAlumnoByNombre(String nombre){
        List<Alumno> alumnos = alRepo.findByNombre(nombre);
        List<AlumnoDTO> alumnoDTOList = new ArrayList<>();

        for (Alumno alumno : alumnos){
            alumnoDTOList.add(new AlumnoDTO(alumno));
        }

        return alumnoDTOList;
    }



    public Alumno getAlumnoById(Long id){
        return alRepo.findById(id).get();
    }

    @Override
    public void insertAlumno(AlumnoDTO alumno){
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setAlumnoId(alumno.getAlumnoId());
        nuevoAlumno.setNombre(alumno.getNombre());
        nuevoAlumno.setApellidos(alumno.getApellidos());

        if (alumno.getContacto() != null){
            Contacto contacto = new Contacto();
            contacto.setDireccion(alumno.getContacto().getDireccion());
            contacto.setTelefono(alumno.getContacto().getTelefono());

            nuevoAlumno.setContacto(contacto);
            contacto.setAlumno(nuevoAlumno);

            /*
            Creación de InfoContacto: El código verifica si alumnoDto tiene información de contacto y,
            si es así, crea un objeto InfoContacto usando los datos proporcionados en AlumnoDTO.

            Relación Bidireccional: Después de configurar el objeto InfoContacto, se establece la 
            relación entre el Alumno y el InfoContacto usando nuevoAlumno.setContacto(contacto); y 
            contacto.setAlumno(nuevoAlumno);.

            Guardado en la Base de Datos: Al guardar nuevoAlumno, se debería guardar también 
            InfoContacto debido al uso de CascadeType.ALL en la relación.
            */
        }

        alRepo.save(nuevoAlumno);
    }

    @Override
    public void saveAlumno(AlumnoDTO alumno){
        alRepo.save(alumno);
    }

    @Override
    public void updateAlumno(Long id, AlumnoDTO alumno){
        alRepo.save(alumno);
    }

    @Override
    public void deleteAlumno(Long id){
        alRepo.deleteById(id);
    }

}
