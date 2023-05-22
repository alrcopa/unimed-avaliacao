import {Component, OnInit} from '@angular/core';
import { Beneficiario } from '../../beneficiario/beneficiario';
import { BeneficiarioService } from 'src/app/services/beneficiario.service';
import { Plano } from '../plano';
import { PlanoService } from 'src/app/services/plano.service';

@Component({
  selector: 'app-plano-form',
  templateUrl: './plano-form.component.html',
  styleUrls: ['./plano-form.component.css']
})
export class PlanoFormComponent implements OnInit {

  beneficiarios: Beneficiario[] = []
  plano: Plano;
  success: boolean = false;
  errors!: String[];
  idBeneficiario!: number;

  constructor(
    private beneficiarioService: BeneficiarioService,
    private service: PlanoService
  ) {
    this.plano = new Plano();
  }

  ngOnInit(): void {
    this.beneficiarioService
      .getBeneficiarios()
      .subscribe( response => this.beneficiarios = response);

  }

  onSubmit(){
    this.plano.beneficiario = new Beneficiario();
    this.plano.beneficiario.id = this.idBeneficiario;
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
