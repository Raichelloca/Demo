package com.example.demo.repositories;

import com.example.demo.models.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

  List<Persona> findAllByNombreAndEdad(String nombre, Integer edad);

  List<Persona> findAllByNombre(String nombre);
}
