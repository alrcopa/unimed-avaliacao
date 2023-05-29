import { Component, OnInit } from '@angular/core';
import { PlanoService } from 'src/app/services/plano.service';

import { Plano } from '../model/plano';

@Component({
  selector: 'app-plano-lista',
  templateUrl: './plano-lista.component.html',
  styleUrls: ['./plano-lista.component.css']
})
export class PlanoListaComponent implements OnInit {

  nome!: string;
  lista!: Plano[];
  message!: string;

  constructor(
    private planoService: PlanoService
  ) { }

  ngOnInit(): void {
    this.planoService
      .getPlanos()
      .subscribe( resposta => {
        console.log(resposta)
        this.lista = resposta
      } );
  }

  consultar(){
    this.planoService
      .buscar(this.nome)
      .subscribe(response => {
        this.lista = response;
        if( this.lista.length <= 0 ){
          this.message = "Nenhum Registro encontrado.";
        }else{
          this.message = '';
        }
      });
  }


}
