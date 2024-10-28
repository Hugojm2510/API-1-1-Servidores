package com.vedruna.api1_1_reinicio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.api1_1_reinicio.dto.AlumnoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Alumno;
import java.util.List;


@Repository
public interface AlumnoRepositoryI extends JpaRepository<Alumno, Long>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<Alumno> findByNombre(String nombre);
    List<Alumno> findByApellidos(String apellidos);
    Alumno findByNombreAndApellidos(String nombre, String apellidos);
    void save(AlumnoDTO alumno);
}