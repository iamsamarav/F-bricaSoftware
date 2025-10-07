import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-cliente-navbar',
  imports: [RouterLink, CommonModule],
  templateUrl: './cliente-navbar.component.html',
  styleUrl: './cliente-navbar.component.css'
})
export class ClienteNavbarComponent {

}
