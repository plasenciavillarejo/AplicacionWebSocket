import { Component, OnInit } from '@angular/core';

// Importanción de las librerías para stomp
import { Client } from '@stomp/stompjs';
import { IStompSocket } from '@stomp/stompjs/esm6';
import SockJS from 'sockjs-client';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [],
  templateUrl: './chat.component.html'
})
export class ChatComponent implements OnInit{

  private client: Client;

  constructor() {
    this.client = new Client();
  }

ngOnInit() : void {
  

  // Asignamos sockjs a stomp para que trabaje por debajo con el
  this.client.webSocketFactory = ()=> {
    // Devolvemos la instancia asignada al Broker dentro de Spring
    return new SockJS("http://localhost:8080/chat-websocket") as IStompSocket;
  }

  // se encarga de saber cuando se conecta
  
  this.client.onConnect = (frame) => {
    console.log('Conectados: ' + this.client.connected + ' : ' + frame);
  }
  // Realizamos la conexíon con el BE
  this.client.activate();

}

}
