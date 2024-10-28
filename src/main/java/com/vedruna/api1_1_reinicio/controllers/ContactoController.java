package com.vedruna.api1_1_reinicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.api1_1_reinicio.dto.ContactoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Alumno;
import com.vedruna.api1_1_reinicio.persistance.models.Contacto;
import com.vedruna.api1_1_reinicio.services.ContactoServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/contacto")
@CrossOrigin
public class ContactoController {
    
    @Autowired
    ContactoServiceI contactoMngmnt;

    // @GetMapping
    // public List<Contacto> getMethodName() {
    //     return contactoMngmnt.getAllContactos();
    // }

    @GetMapping
    public List<ContactoDTO> getMethodName() {
        return contactoMngmnt.getAllContactos();
    }
    

    @GetMapping("/telefono/{telefono}")
    public List<ContactoDTO> getMethodTelefono(@PathVariable String telefono) {
        return contactoMngmnt.getContactoByTelefono(telefono);
    }

    @PostMapping("/insert")
    public void insertContacto(@RequestBody ContactoDTO contacto) {        
        contactoMngmnt.insertContacto(contacto);
    }
    
    @PutMapping("/edit/{id}")
    public void editContacto(@PathVariable Long id, @RequestBody ContactoDTO contacto) {
        contactoMngmnt.updateContacto(id, contacto);        
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContacto(@PathVariable Long id){
        contactoMngmnt.deleteContacto(id);
    }

}
