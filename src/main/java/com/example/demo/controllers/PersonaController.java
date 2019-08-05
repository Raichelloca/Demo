package com.example.demo.controllers;

import com.example.demo.models.Persona;
import com.example.demo.services.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/persona")
public class PersonaController {


  private PersonaService service;

  @Autowired
  public PersonaController(PersonaService service) {
    this.service = service;
  }

  @PostMapping("/save")
  public @ResponseBody Persona savePersona(@RequestParam String nombre, @RequestParam Integer edad){

    return service.savePersona(new Persona(nombre,edad));

  }

  @GetMapping
  public @ResponseBody List<Persona> getPersonas(){

    return service.getPersonas();

  }
  @GetMapping("/{id}")
  public ResponseEntity<Persona> getPersona(@PathVariable Long id){
    final Optional<com.example.demo.models.Persona> persona = service.getPersona(id);
    return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

  }

  @GetMapping("/getnombre")
  public @ResponseBody List<Persona> getPersonasByNombre(@RequestParam String nombre, @RequestParam(required = false) Integer edad){

    return service.getPersonasByNombreAndEdad(nombre,edad);

  }

}
