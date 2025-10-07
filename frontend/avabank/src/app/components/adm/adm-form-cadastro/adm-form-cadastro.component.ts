import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from '../../../services/cliente.service';
import { Cliente } from '../../../classes/cliente';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-adm-form-cadastro',
  imports: [CommonModule, FormsModule],
  templateUrl: './adm-form-cadastro.component.html',
  styleUrl: './adm-form-cadastro.component.css'
})
export class AdmFormCadastroComponent {

  constructor(
    private router: Router,
    private clienteService: ClienteService,
    private toastr: ToastrService
  ) { }

  cliente: Cliente = new Cliente();

  fechar(): void {
    this.router.navigate(['/adm-home'])
  }

//    mostrar(): void {
//      window.alert(this.cliente.mostrar());
//    }

  consultarCep(): void {
    const cep = this.cliente.endereco.cep;

    if(cep && cep.length== 8) {
      this.clienteService.buscarCep(cep)
      .subscribe({
        next: (dados) => {
          if(!dados.erro){
            this.cliente.endereco.logradouro = dados.logradouro;
            this.cliente.endereco.bairro = dados.bairro;
            this.cliente.endereco.cidade = dados.localidade;
            this.cliente.endereco.uf = dados.uf;
            this.cliente.endereco.estado = dados.estado;
          }else{
            this.toastr.error("Cep não encontrado!");
          }

        }
        }
      )
    }
  }

  incluir(cliente: Cliente): void {
    this.clienteService.postClienteApi(cliente)
    .subscribe({
      next: () => {
        this.toastr.success("Cliente cadastrado com sucesso");
        setTimeout(() => this.fechar(), 2000);
      },
        error: erro => {
          console.log(erro);
          this.toastr.error("Erro ao cadastrar cliente, verifique as informações");
        }
      });
  }
}
