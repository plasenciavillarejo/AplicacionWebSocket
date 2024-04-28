package com.web.socket.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensajes")
public class Mensaje implements Serializable {

  private String texto;

  private Long fecha;

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public Long getFecha() {
    return fecha;
  }

  public void setFecha(Long fecha) {
    this.fecha = fecha;
  }

  public Mensaje(String texto, Long fecha) {
	  this.texto = texto;
	  this.fecha = fecha;
  }
  
  private static final long serialVersionUID = -1386583462555421832L;

}
