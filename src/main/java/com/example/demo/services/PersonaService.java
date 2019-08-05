package com.example.demo.services;

import com.example.demo.models.Persona;
import com.example.demo.repositories.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

  private PersonaRepository repository;

  @Autowired
  public PersonaService(PersonaRepository repository) {
    this.repository = repository;
  }


  public Persona savePersona(Persona persona){
    return repository.save(persona);
  }

  public List<Persona> getPersonas(){
    return repository.findAll();
  }

  public List<Persona> getPersonasByNombreAndEdad(String nombre, Integer edad) {
    if(edad==null){
      return repository.findAllByNombre(nombre);
    }
    return repository.findAllByNombreAndEdad(nombre, edad);
  }

  public Optional<Persona> getPersona(Long id) {
    return repository.findById(id);
  }
}
