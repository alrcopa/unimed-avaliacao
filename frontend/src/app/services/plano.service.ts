import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

import {Plano} from '../view/plano/model/plano';
import {Beneficiario} from "../view/beneficiario/model/beneficiario";

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

  getPlanoById(id: number) : Observable<Plano> {
    return this.http.get<any>(`${this.apiURL}/${id}`);
  }

  atualizar( plano: Plano ) : Observable<any> {
    return this.http.put<Beneficiario>(`${this.apiURL}` , plano);
  }

}
