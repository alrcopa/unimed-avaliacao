import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Plano } from '../view/plano/plano';
import {Beneficiario} from "../view/beneficiario/beneficiario";

@Injectable({
  providedIn: 'root'
})
export class PlanoService {

  apiURL: string = 'http://localhost:8050' + "/api/plano"

  constructor(private http: HttpClient) { }

  getPlanos() : Observable<Plano[]> {
    return this.http.get<Plano[]>(this.apiURL);
  }

  salvar(plano: Plano) : Observable<Plano>{
    return this.http.post<Plano>(this.apiURL, plano);
  }

  buscar(nome: string) : Observable<Plano[]>{
    return this.http.post<any>(this.apiURL + "/pesquisar", nome);
  }

}
