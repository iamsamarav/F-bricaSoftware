import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../classes/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) {

  }

  baseUrl: string = "http://localhost:8080/administradores/";

  //método para listar todos os administradores
  public getAdminsApi(): Observable<Admin[]> {
    const url: string = "lista"

    return this.http.get<Admin[]>(`${this.baseUrl}${url}`);
  }

  //método para incluir novos administradores
  public postAdminApi(admin: Admin): Observable<Admin> {
    const url: string = "incluir"

    return this.http.post<Admin>(`${this.baseUrl}${url}`, admin);
  }

  //método para alterar um administrador
  // public putAdminApi(admin: Admin, id: number): Observable<Admin> {
  //   const url: string = `alterar/${id}`;
  //   return this.http.put<Admin>(`${this.baseUrl}${url}`, admin);
  // }
}
