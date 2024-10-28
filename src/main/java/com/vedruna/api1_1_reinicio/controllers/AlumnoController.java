package com.vedruna.api1_1_reinicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.api1_1_reinicio.dto.AlumnoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Alumno;
import com.vedruna.api1_1_reinicio.services.AlumnoServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/alumno")
@CrossOrigin
public class AlumnoController {
    
    @Autowired
    AlumnoServiceI alumnoMngmnt;

    @GetMapping
    public List<Alumno> getMethodName() {
        List<Alumno> alumnos = alumnoMngmnt.getAllAlumnos();
        for (Alumno alumno : alumnos){
            alumno.setContacto(null);
        }
        return alumnos;
    }
    

    @GetMapping("/name/{nombre}")
    public List<AlumnoDTO> getMethodName(@PathVariable String nombre) {
        List<AlumnoDTO> alumnos = alumnoMngmnt.getAlumnoByNombre(nombre);
        return alumnos;
    }

    @PostMapping("/insert")
    public void insertAlumno(@RequestBody AlumnoDTO alumno) {
        alumnoMngmnt.insertAlumno(alumno);        
    }
    
    @PutMapping("/edit/{id}")
    public void editAlumno(@PathVariable Long id, @RequestBody AlumnoDTO alumno) {
        Alumno alumnoExiste = alumnoMngmnt.getAlumnoById(id);

        alumnoExiste.setNombre(alumno.getNombre());
        alumnoExiste.setApellidos(alumno.getApellidos());

        alumnoMngmnt.updateAlumno(id, alumno);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteAlumno(@PathVariable Long id) {
        alumnoMngmnt.deleteAlumno(id);
    }

}
