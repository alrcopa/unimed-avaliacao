import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BeneficiarioService } from 'src/app/services/beneficiario.service';

import { Beneficiario } from '../beneficiario';

@Component({
  selector: 'app-beneficiario-lista',
  templateUrl: './beneficiario-lista.component.html',
  styleUrls: ['./beneficiario-lista.component.css']
})
export class BeneficiarioListaComponent implements OnInit {

  beneficiarios: Beneficiario[] = [];
  beneficiarioSelecionado!: Beneficiario;
  mensagemSucesso!: string;
  mensagemErro!: string;

  constructor(
    private service: BeneficiarioService,
    private router: Router) {}

  ngOnInit(): void {
    this.service
      .getBeneficiarios()
      .subscribe( resposta => this.beneficiarios = resposta );
  }

  novoCadastro(){
    this.router.navigate(['/beneficiario/form'])
  }

  preparaDelecao(beneficiario: Beneficiario){
    this.beneficiarioSelecionado = beneficiario;
  }

  deletarBeneficiario(){
    this.service
      .deletar(this.beneficiarioSelecionado)
      .subscribe(
        response => {
          this.mensagemSucesso = 'Beneficiario deletado com sucesso!'
          this.ngOnInit();
        },
        erro => this.mensagemErro = 'Ocorreu um erro ao deletar o beneficiario.'
      )
  }
}

