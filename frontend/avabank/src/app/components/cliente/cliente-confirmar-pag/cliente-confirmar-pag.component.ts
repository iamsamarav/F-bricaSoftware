import { Component, OnInit } from '@angular/core';
import { ClienteTituloComponent } from "../cliente-titulo/cliente-titulo.component";
import { TransacaoService } from '../../../services/transacao.service';
import { Transacao } from '../../../classes/transacao';

@Component({
  selector: 'app-cliente-confirmar-pag',
  imports: [ClienteTituloComponent],
  templateUrl: './cliente-confirmar-pag.component.html',
  styleUrls: ['./cliente-confirmar-pag.component.css']
})
export class ClienteConfirmarPagComponent implements OnInit{

  titulo: string = 'Confirme o pagamento'; // Atribuindo o valor ao título

  constructor(private transacaoService: TransacaoService) {
    this.titulo =  'Confirme o pagamento';
  }

  ngOnInit():void{
    this.transacaoService
    .getTransferenciaApi()
    .subscribe(resposta => this.transacao = resposta);
  }

  transacao: Transacao[] = [];
}
