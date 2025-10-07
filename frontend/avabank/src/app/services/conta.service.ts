import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Conta } from '../classes/conta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContaService {

  constructor(private http: HttpClient) {
  }

  baseUrl: string = "http://localhost:8080/contas/";

  //método para buscar conta por admin
  public getContasPorAdminApi(username: string): Observable<Conta[]> {
    const url: string = `lista/${username}`;
    return this.http.get<Conta[]>(`${this.baseUrl}${url}`);
  }

  //método para incluir nova conta
  public postContaApi(conta: Conta): Observable<Conta> {
    const url: string = "incluir"

    return this.http.post<Conta>(`${this.baseUrl}${url}`, conta);
  }

  //método para alterar uma conta
  public putContaApi(conta: Conta, numeroConta: number): Observable<Conta> {
    const url: string = `alterar/${numeroConta}`;
    return this.http.put<Conta>(`${this.baseUrl}${url}`, conta);
  }
}
