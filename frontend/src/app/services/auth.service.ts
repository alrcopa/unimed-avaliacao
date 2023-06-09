import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

import { Usuario } from '../login/usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // apiURL: string = environment.apiURLBase + "/api/usuarios"
  // tokenURL: string = environment.apiURLBase + environment.obterTokenUrl
  // clientID: string = environment.clientId;
  // clientSecret: string = environment.clientSecret;

  apiURLBase: string = 'http://localhost:8050'

  apiURL: string = this.apiURLBase + "/api/usuario"
  tokenURL: string = this.apiURLBase + '/login'
  // clientID: string = 'my-angular-app';
  // clientSecret: string = '@321';
  jwtHelper: JwtHelperService = new JwtHelperService();

  constructor(
    private http: HttpClient
  ) { }

  obterToken(){
    const tokenString = localStorage.getItem('access_token')
    if(tokenString){
      const token = JSON.parse(tokenString).access_token
      return token;
    }
    return null;
  }

  encerrarSessao(){
    localStorage.removeItem('access_token')
  }

  getUsuarioAutenticado(){
    const token = this.obterToken();
    if(token){
      const usuario = this.jwtHelper.decodeToken(token).user_name
      return usuario;
    }
    return null;
  }

  isAuthenticated() : boolean {
    const token = this.obterToken();
    if(token){
      const expired = this.jwtHelper.isTokenExpired(token)
      return !expired;
    }
    return false;
  }

  salvar(usuario: Usuario) : Observable<any> {
    return this.http.post<any>(this.apiURL + '/salvar', usuario);
  }

  tentarLogar( usuario: Usuario) : Observable<any> {
      return this.http.post( this.tokenURL , usuario);
  }
}
