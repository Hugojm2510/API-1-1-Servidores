package com.vedruna.api1_1_reinicio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.api1_1_reinicio.dto.ContactoDTO;
import com.vedruna.api1_1_reinicio.persistance.models.Alumno;
import com.vedruna.api1_1_reinicio.persistance.models.Contacto;
import com.vedruna.api1_1_reinicio.persistance.repository.ContactoRepositoryI;

@Service
public class ContactoServiceImpI implements ContactoServiceI{

    @Autowired
    ContactoRepositoryI coRepo;

    @Autowired
    AlumnoServiceI alumnoMngmnt;

    // @Override
    // public List<Contacto> getAllContactos(){
    //     return coRepo.findAll();
    // }


    @Override
public List<ContactoDTO> getAllContactos() {
    List<Contacto> contactos = coRepo.findAll();
    List<ContactoDTO> contactoDTOs = new ArrayList<>();

    for (Contacto contacto : contactos) {
        ContactoDTO contactoDTO = new ContactoDTO();
        contactoDTO.setIdContacto(contacto.getIdContacto());
        contactoDTO.setDireccion(contacto.getDireccion());
        contactoDTO.setTelefono(contacto.getTelefono());
        
        // Verificar si el alumno es nulo antes de asignar el ID
        if (contacto.getAlumno() != null) {
            contactoDTO.setAlumnos_idalumno(contacto.getAlumno().getAlumnoId());
        } else {
            contactoDTO.setAlumnos_idalumno(null); // O no lo asignes, según tu preferencia
        }
        
        contactoDTOs.add(contactoDTO);
    }

    return contactoDTOs;
}

    // @Override
    // public List<ContactoDTO> getAllContactos(){
    //     List<Contacto> contactoList = coRepo.findAll();
    //     List<ContactoDTO> contactoDTOList = new ArrayList<>();

    //     for (Contacto alumno : contactoList){
    //         contactoDTOList.add(new ContactoDTO(alumno));
    //     }

    //     return contactoDTOList;
    // }

    @Override
    public void insertContacto(ContactoDTO contacto){
        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setIdContacto(contacto.getIdContacto());
        nuevoContacto.setDireccion(contacto.getDireccion());
        nuevoContacto.setTelefono(contacto.getTelefono());

        Alumno alumno = alumnoMngmnt.getAlumnoById(contacto.getAlumnos_idalumno());

        nuevoContacto.setAlumno(alumno);
        coRepo.save(nuevoContacto);
    }


    @Override
    public List<ContactoDTO> getContactoByTelefono(String telefono) {
        List<Contacto> contactoList = coRepo.findByTelefono(telefono); // Llama al repositorio
        List<ContactoDTO> contactoDTOList = new ArrayList<>();

        // Mapea Contacto a ContactoDTO
        for (Contacto alumno : contactoList) {
            contactoDTOList.add(new ContactoDTO(alumno));
        }

        return contactoDTOList;
    }


    @Override
    public void saveContacto(ContactoDTO contacto){
        coRepo.save(contacto);
    }


    @Override
    public void updateContacto(Long id, ContactoDTO contacto){
        contacto.setIdContacto(id);
        coRepo.save(contacto);
    }


    @Override
    public void deleteContacto(Long id){
        coRepo.deleteById(id);
    }
}
