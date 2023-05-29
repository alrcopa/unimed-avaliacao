import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { BeneficiarioService } from 'src/app/services/beneficiario.service';

import { Beneficiario } from '../model/beneficiario';
import {PlanoService} from "../../../services/plano.service";
import {Plano} from "../../plano/model/plano";


@Component({
  selector: 'app-beneficiario-form',
  templateUrl: './beneficiario-form.component.html',
  styleUrls: ['./beneficiario-form.component.css']
})
export class BeneficiarioFormComponent implements OnInit{

  planos: Plano [] = [];
  beneficiario!: Beneficiario;
  success: boolean = false;
  errors!: String[];
  id!: number;
  idPlano!: number;

  constructor(
      private router: Router,
      private activatedRoute : ActivatedRoute,
      private service: BeneficiarioService ,
      private planoService: PlanoService) {
    this.beneficiario = new Beneficiario();
  }

  ngOnInit(): void {
    this.planoService
      .getPlanos()
      .subscribe( response => this.planos = response);

    let params : Observable<Params> = this.activatedRoute.params
    params.subscribe( urlParams => {
        this.id = urlParams['id'];
        if(this.id){
          this.service
            .getBeneficiarioById(this.id)
            .subscribe(
              response => this.beneficiario = response ,
              errorResponse => this.beneficiario = new Beneficiario()
            )
        }
    })
  }

  voltarParaListagem(){
    this.router.navigate(['/beneficiario/lista'])
  }

  onSubmit(){
    if(this.id){

      this.service
        .atualizar(this.beneficiario)
        .subscribe(response => {
            this.success = true;
            this.errors = [];
        }, errorResponse => {
          this.errors = ['Erro ao atualizar o beneficiario.']
        })

    }else{
      this.service
        .salvar(this.beneficiario)
          .subscribe( response => {
            this.success = true;
            this.errors = [];
            this.beneficiario = response;
          } , errorResponse => {
            this.success = false;
            this.errors = errorResponse.error.errors;
          })

    }

  }

}
