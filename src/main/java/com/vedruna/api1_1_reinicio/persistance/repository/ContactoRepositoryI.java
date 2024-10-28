package com.vedruna.api1_1_reinicio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.api1_1_reinicio.dto.ContactoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Contacto;
import java.util.List;


public interface ContactoRepositoryI extends JpaRepository<Contacto, Long>{
    
    List<Contacto> findByDireccion(String direccion);
    List<Contacto> findByTelefono(String telefono);
    List<Contacto> findByDireccionAndTelefono(String direccion, String telefono);
    void save(ContactoDTO contacto);
    void deleteById(Long id);

}
