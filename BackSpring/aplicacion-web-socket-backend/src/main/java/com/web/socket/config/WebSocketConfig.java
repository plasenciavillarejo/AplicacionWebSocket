package com.web.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// Habilitamos el servidor broker en spring
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    // Aquí se le indica el endpoint que se quiere agregar para conectar desde angular a este servidor websocket
    registry.addEndpoint("/chat-websocket")
    // Habilitamos el origin de angular
    .setAllowedOriginPatterns("http://localhost:4200")
    /* habilitamos la librería que por debajo va a utilizar SockJs() que nos permite utilizar el protocolo http para conectar con angular
     de lo contrario nos obliga a conectar con la api nativa de html5 pero este solo soparte el protocolo ws */
    .withSockJS();
  }
  
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    /* Este es un prefijo, sirve para los nombres de eventos, cuando el servidor emite un mensaje debe notificar a todos los clientes mediante el nombre del evento,
    par que los cliente que este subscritos este avisados del evento */
    registry.enableSimpleBroker("/chat/");
    // Prefijo de el destino cuando publicamos un mensaje, enviamos nuestro payload hacia nuestro websocket
    registry.setApplicationDestinationPrefixes("/app");
  }
  
}