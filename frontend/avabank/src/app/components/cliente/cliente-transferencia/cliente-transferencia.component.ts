import { Component } from '@angular/core';
import { ClienteTituloComponent } from "../cliente-titulo/cliente-titulo.component";
import { Router, RouterLink } from '@angular/router';
import { TransacaoService } from '../../../services/transacao.service';
import { Transacao } from '../../../classes/transacao';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cliente-transferencia',
  imports: [ClienteTituloComponent, RouterLink, FormsModule],
  templateUrl: './cliente-transferencia.component.html',
  styleUrl: './cliente-transferencia.component.css'
})
export class ClienteTransferenciaComponent {

  transferData = {
    agencia: '',
    numeroConta: '',
    cpf: '',
    nome:'',
    valor: '',
    tipoTransacao: 'T'
  };

  titulo: string = 'Transferência'; 
  constructor(private router: Router, private transacaoService: TransacaoService) {}
  
  transacao: Transacao = new Transacao();
  ngOnInit(): void {}

  incluir(transacao: Transacao) : void {
    this.transacaoService.postTransferenciaApi(transacao)
    .subscribe({
      complete:() => this.router.navigate(['/cliente/cliente-confirmar-pag']),
      error: erro => {
        console.error(erro);
        window.alert(erro);
      }
    });
  }
}
