import {Component, OnInit} from '@angular/core';
import {Plano} from '../model/plano';
import {PlanoService} from 'src/app/services/plano.service';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-plano-form',
  templateUrl: './plano-form.component.html',
  styleUrls: ['./plano-form.component.css']
})
export class PlanoFormComponent implements OnInit {


  plano: Plano;
  success: boolean = false;
  errors!: String[];
  id!: number;

  constructor(
    private router: Router,
    private activatedRoute : ActivatedRoute,
    private service: PlanoService) {
    this.plano = new Plano();
  }

  ngOnInit(): void {
    let params : Observable<Params> = this.activatedRoute.params
    params.subscribe( urlParams => {
      this.id = urlParams['id'];
      if(this.id){
        this.service
          .getPlanoById(this.id)
          .subscribe(
            response => this.plano = response ,
            errorResponse => this.plano = new Plano()
          )
      }
    })
  }

  onSubmit(){

    if(this.id){

      this.service
        .atualizar(this.plano)
        .subscribe(response => {
          this.success = true;
          this.errors = [];
        }, errorResponse => {
          this.errors = ['Erro ao atualizar o beneficiario.']
        })

    }else{
      this.service
        .salvar(this.plano)
        .subscribe( response => {
          this.success = true;
          this.errors = [];
          this.plano = new Plano();
        } , errorResponse => {
          this.success = false;
          this.errors = errorResponse.error.errors;
        })

    }


  }

}
