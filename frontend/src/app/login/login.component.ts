import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../services/auth.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  // public requestLogin: Usuario = new Usuario;

  login!: string;
  senha!: string;
  nome!:string;
  cadastrando!: boolean;
  mensagemSucesso!: string;
  errors!: String[];

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  onSubmit(){
    const usuario: Usuario = new Usuario();
    usuario.login = this.login;
    usuario.senha = this.senha;
    this.authService
          .tentarLogar(usuario)
          .subscribe(response => {
            const access_token = JSON.stringify(response);
            localStorage.setItem('access_token', access_token)
            this.router.navigate(['/home'])

          }, errorResponse => {
            this.errors = ['Usuário e/ou senha incorreto(s).']
          })

  }

  preparaCadastrar(event: { preventDefault: () => void; }) {
    event.preventDefault();
    this.cadastrando = true;
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }

  cadastrar(){
    const usuario: Usuario = new Usuario();
    usuario.login = this.login;
    usuario.senha = this.senha;
    usuario.nome = this.nome;
    this.authService
        .salvar(usuario)
        .subscribe( response => {
            this.mensagemSucesso = "Cadastro realizado com sucesso! Efetue o login.";
            this.cadastrando = false;
            this.login = '';
            this.senha = '';
            this.errors = []
        }, errorResponse => {
            this.mensagemSucesso = '';
            this.errors = errorResponse.error.errors;
        })
  }


}
