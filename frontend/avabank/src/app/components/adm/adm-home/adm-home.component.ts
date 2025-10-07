import { Component, OnInit } from '@angular/core';
import { ContaService } from '../../../services/conta.service';
import { ButtonRoxoComponent } from "../../common/button-roxo/button-roxo.component";
import { CommonModule } from '@angular/common';
import { ClienteService } from '../../../services/cliente.service';
import { Cliente } from '../../../classes/cliente';
import { LocalStorageService } from '../../../services/local-storage.service';
import { Conta } from '../../../classes/conta';

@Component({
  selector: 'app-adm-home',
  imports: [ButtonRoxoComponent, CommonModule],
  templateUrl: './adm-home.component.html',
  styleUrl: './adm-home.component.css'
})
export class AdmHomeComponent implements OnInit {
  qtdContas: number = 0;
  clientes: Cliente[] = [];
  contas: Conta[] = [];

  constructor(private contaService: ContaService,
    private clienteService: ClienteService,
    private localStorage: LocalStorageService
  ) {}

  ngOnInit(): void {
    this.clienteService
    .getClienteApi()
    .subscribe( resposta => {
      this.clientes = resposta;
      this.qtdContas = resposta.length;
    })
    this.contaService.getContasPorAdminApi('iamsamara').subscribe(
      resposta => this.contas = resposta
    )
    console.log('Clientes:', this.clientes); 
    };
  }

