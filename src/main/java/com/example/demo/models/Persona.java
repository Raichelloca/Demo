package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Persona {

  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_idGenerator")
  @SequenceGenerator(
      name = "persona_idGenerator",
      sequenceName = "persona_id_seq",
      allocationSize = 1
  )
  @Id
  @Column
  private Long id;

  @Column
  private String nombre;

  @Column
  private Integer edad;

  public Persona() {
  }

  public Persona(String nombre, Integer edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }
}
