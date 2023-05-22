import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { BeneficiarioService } from 'src/app/services/beneficiario.service';

import { Beneficiario } from '../beneficiario';


@Component({
  selector: 'app-beneficiario-form',
  templateUrl: './beneficiario-form.component.html',
  styleUrls: ['./beneficiario-form.component.css']
})
export class BeneficiarioFormComponent implements OnInit{

  beneficiario!: Beneficiario;
  success: boolean = false;
  errors!: String[];
  id!: number;

  constructor(
      private service: BeneficiarioService ,
      private router: Router,
      private activatedRoute : ActivatedRoute
      ) {
    this.beneficiario = new Beneficiario();
  }

  ngOnInit(): void {
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

      console.log(this.beneficiario)
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
