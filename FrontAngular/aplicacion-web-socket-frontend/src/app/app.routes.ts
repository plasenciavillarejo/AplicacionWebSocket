import { Routes } from '@angular/router';
import { ChatComponent } from './chat/chat.component';

// En esta parte se agregan todas las rutas de la navegación
export const routes: Routes = [
    // Ruta por defecto que apunta al chat de inicio
    {path: '', redirectTo: 'chat', pathMatch: 'full'},
    // Ruta del chat
    {path: 'chat', component: ChatComponent } 
];
