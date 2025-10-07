import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agencia } from '../classes/agencia';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgenciaService {

  constructor(private http: HttpClient) {

  }

  baseUrl: string = "http://localhost:8080/agencias/";

  //método para listar todos as agencias
  public getAgenciasApi(): Observable<Agencia[]> {
    const url: string = "lista"

    return this.http.get<Agencia[]>(`${this.baseUrl}${url}`);
  }

  //método para listar todos as agencias
  public getAgenciaApi(id: number): Observable<Agencia[]> {
    const url: string = `lista/${id}`

    return this.http.get<Agencia[]>(`${this.baseUrl}${url}`);
  }
}
