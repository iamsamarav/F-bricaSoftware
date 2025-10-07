import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../classes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  baseUrl: string = "http://localhost:8080/clientes";
  viaCepUrl: string = "http://viacep.com.br/ws"

  //método para buscar cliente
  public getClienteApi(): Observable<Cliente[]> {
    const url: string = `lista`;
    return this.http.get<Cliente[]>(`${this.baseUrl}/${url}`);
  }

  // //método para buscar cliente
  // public getClienteApi(id: number): Observable<Cliente> {
  //   const url: string = `lista/${id}`;
  //   return this.http.get<Cliente>(`${this.baseUrl}/${url}`);
  // }

  //método para incluir novo cliente
  public postClienteApi(cliente: Cliente): Observable<Cliente> {
    const url: string = "incluir"

    return this.http.post<Cliente>(`${this.baseUrl}/${url}`, cliente);
  }

  //buscar endereço no viacep
  public buscarCep(cep : string): Observable<any>{
    return this.http.get(`${this.viaCepUrl}/${cep}/json/`);
  }

  //método para alterar um cliente
  public putClienteApi(cliente: Cliente, id: number): Observable<Cliente> {
    const url: string = `alterar/${id}`;
    return this.http.put<Cliente>(`${this.baseUrl}/${url}`, cliente);
  }
}
