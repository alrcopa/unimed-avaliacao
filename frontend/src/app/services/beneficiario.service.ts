import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Beneficiario } from '../view/beneficiario/model/beneficiario';

@Injectable({
  providedIn: 'root'
})
export class BeneficiarioService {

  apiURLBase: string = 'http://localhost:8050';

  apiURL: string = this.apiURLBase + '/api/beneficiario';

  constructor( private http: HttpClient ) {}

  salvar( beneficiario: Beneficiario ) : Observable<Beneficiario> {
    return this.http.post<Beneficiario>( `${this.apiURL}` , beneficiario);
  }

  atualizar( beneficiario: Beneficiario ) : Observable<any> {
    return this.http.put<Beneficiario>(`${this.apiURL}` , beneficiario);
  }

  getBeneficiarios() : Observable<Beneficiario[]> {
    return this.http.get<Beneficiario[]>(this.apiURL);
  }

  getBeneficiarioById(id: number) : Observable<Beneficiario> {
    return this.http.get<any>(`${this.apiURL}/${id}`);
  }

  deletar(beneficiario: Beneficiario) : Observable<any> {
    return this.http.delete<any>(`${this.apiURL}/${beneficiario.id}`);
  }
}
