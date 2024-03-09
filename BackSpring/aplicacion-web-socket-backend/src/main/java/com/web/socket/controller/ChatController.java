package com.web.socket.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.web.socket.models.entity.Mensaje;

@Controller
public class ChatController {

  // Indicamos el destino  
  @MessageMapping("/mensaje")
  // Indicamos el nombre del evento a cual vamos a enviar el mensaje, deben de estar subscritos para recibir la información
  // debemos e indicar el prefijo del enableSimpleBroker() configurado anteriormente
  @SendTo("/chat/mensaje")
  public Mensaje recibirMensaje(Mensaje mensaje) {
    // Recibie algo de los clientes
    mensaje.setFecha(new Date().getTime());
    mensaje.setTexto("Recibido por el broker : ".concat(mensaje.getTexto()));
    // enviamos la respueta para notificar a todos los clientes de la informacion
    return mensaje;
  }
  
}
