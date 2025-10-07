import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AdminNavbarComponent } from "./components/navbar/admin-navbar/admin-navbar.component";
import { StartNavbarComponent } from "./components/navbar/start-navbar/start-navbar.component";
import { ClienteNavbarComponent } from './components/navbar/cliente-navbar/cliente-navbar.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ClienteNavbarComponent, AdminNavbarComponent, StartNavbarComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent implements OnInit {
  title = 'avabank';

  ngOnInit(): void {
  }

}
