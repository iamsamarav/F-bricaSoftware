import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-cliente-titulo',
  templateUrl: './cliente-titulo.component.html',
  styleUrls: ['./cliente-titulo.component.css']
})
export class ClienteTituloComponent {
  @Input() titulo: string = ''; // Definindo o título como uma propriedade de entrada
}
