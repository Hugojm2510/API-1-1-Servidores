package com.vedruna.api1_1_reinicio.services;

import java.util.List;

import com.vedruna.api1_1_reinicio.dto.ContactoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Contacto;

public interface ContactoServiceI {
    
    List<ContactoDTO> getAllContactos();
    List<ContactoDTO> getContactoByTelefono(String telefono);
    void insertContacto(ContactoDTO contacto);
    void saveContacto(ContactoDTO contacto);
    void updateContacto(Long id, ContactoDTO contacto);
    void deleteContacto(Long id);
}
