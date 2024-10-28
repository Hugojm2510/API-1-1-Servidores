package com.vedruna.api1_1_reinicio.services;

import java.util.List;

import com.vedruna.api1_1_reinicio.dto.AlumnoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Alumno;

public interface AlumnoServiceI {
    
    List<Alumno> getAllAlumnos();
    List<AlumnoDTO> getAlumnoByNombre(String nombre);
    Alumno getAlumnoById(Long id);
    void insertAlumno(AlumnoDTO alumno);
    void saveAlumno(AlumnoDTO alumno);
    void updateAlumno(Long id, AlumnoDTO alumno);
    void deleteAlumno(Long id);
}
