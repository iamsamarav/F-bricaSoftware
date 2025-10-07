import { Component } from '@angular/core';
import { Cliente } from '../../../classes/cliente';
import { Router } from '@angular/router';
import { ClienteService } from '../../../services/cliente.service';

@Component({
  selector: 'app-cliente-login',
  imports: [],
  templateUrl: './cliente-login.component.html',
  styleUrl: './cliente-login.component.css'
})
export class ClienteLoginComponent {

    cliente: Cliente = new Cliente();
    erro!: string;
  
    constructor(
      private router: Router,
      private clienteService: ClienteService,
    ) {}
  
    ngOnInit(): void {
      localStorage.removeItem('nome_usuario');
    }

validar(cliente: Cliente): void {
    this.clienteService.getClienteApi().subscribe({
      next: (clientes: Cliente[]) => {
        console.log('Administradores recebidos da API:', clientes); // Verifique se a lista de administradores está correta
        console.log(cliente);
        const usuarioValido = clientes.find(
          (u) => u.username == cliente.agencia
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
