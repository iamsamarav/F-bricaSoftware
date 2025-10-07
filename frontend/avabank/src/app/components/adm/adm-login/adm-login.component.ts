import { Component, OnInit, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../../../services/admin.service';
import { Admin } from '../../../classes/admin';

@Component({
  selector: 'adm-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './adm-login.component.html',
  styleUrl: './adm-login.component.css',
})
export class AdmLoginComponent implements OnInit {
  admin: Admin = new Admin();
  erro!: string;

  constructor(
    private router: Router,
    private adminService: AdminService,
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('nome_usuario');
  }

  validar(admin: Admin): void {
    this.adminService.getAdminsApi().subscribe({
      next: (admins: Admin[]) => {
        console.log('Administradores recebidos da API:', admins); // Verifique se a lista de administradores está correta
        console.log(admin);
        const usuarioValido = admins.find(
          (u) => u.username == admin.username
        );
        console.log(usuarioValido)
        if (usuarioValido) {
          localStorage.setItem('nome_usuario', admin.username);
          console.log('Login bem-sucedido, redirecionando para /home-admin'); // Log para depuração
          this.router.navigate(['/adm-home']);
        } else {
          this.erro = 'Usuário ou senha inválidos';}
      },
      error: (err) => {
        console.error('Erro ao obter administradores:', err);
        this.erro = 'Erro ao validar o login. Tente novamente mais tarde.';
      }
    });
  }
  
}
