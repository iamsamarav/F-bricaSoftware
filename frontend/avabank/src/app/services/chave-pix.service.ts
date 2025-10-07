import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChavePix } from '../classes/chave-pix';
import { Resposta } from '../classes/resposta';

@Injectable({
  providedIn: 'root'
})
export class ChavePixService {

  constructor(private http: HttpClient) {

  }

  baseUrl: string = "http://localhost:8080/chavespix/";

  //método para buscar as chaves pix da conta
  public getChavePixPorContaApi(numeroConta: number): Observable<ChavePix> {
    const url: string = `lista/${numeroConta}`;
    return this.http.get<ChavePix>(`${this.baseUrl}${url}`);
  }

  //método para incluir novas chaves pix
  public postChavePixApi(chavePix: ChavePix): Observable<ChavePix> {
    const url: string = "incluir"

    return this.http.post<ChavePix>(`${this.baseUrl}${url}`, chavePix);
  }

  //método para remover um candidato
  public deleteChavePixApi(id: number): Observable<Resposta> {
    const url: string = `remover/${id}`;
    return this.http.delete<Resposta>(`${this.baseUrl}${url}`);
  }
}
