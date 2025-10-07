import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Transacao } from '../classes/transacao';

@Injectable({
  providedIn: 'root'
})
export class TransacaoService {
  
  constructor(private http: HttpClient) { }

  baseUrl: string = "http://localhost:8081/transacoes";

  public getTransferenciaApi(): Observable<Transacao[]> {
    const url: string = "listar";
    return this.http.get<Transacao[]>(`${this.baseUrl}/${url}`);
    }


  public postTransferenciaApi(transacao: Transacao) : Observable<Transacao> {
    transacao.tipoTransacao = 'T';
    const url : string = "transferencia/incluir";
    return this.http.post<Transacao>(`${this.baseUrl}/${url}`, transacao);
 }
}
