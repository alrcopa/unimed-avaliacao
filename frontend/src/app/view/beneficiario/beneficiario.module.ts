import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { BeneficiarioFormComponent } from './beneficiario-form/beneficiario-form.component';
import { BeneficiarioListaComponent } from './beneficiario-lista/beneficiario-lista.component';
import { BeneficiarioRoutingModule } from './beneficiario-routing.module';


@NgModule({
  declarations: [
    BeneficiarioFormComponent,
    BeneficiarioListaComponent
  ],
  imports: [
    CommonModule,
    BeneficiarioRoutingModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    BeneficiarioFormComponent,
    BeneficiarioListaComponent
  ]
})
export class BeneficiarioModule { }
