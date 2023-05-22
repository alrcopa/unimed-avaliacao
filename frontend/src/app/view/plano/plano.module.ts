import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { PlanoFormComponent } from './plano-form/plano-form.component';
import { PlanoListaComponent } from './plano-lista/plano-lista.component';
import { PlanoRoutingModule } from './plano-routing.module';


@NgModule({
  declarations: [
    PlanoFormComponent,
    PlanoListaComponent
  ],
  imports: [
    CommonModule,
    PlanoRoutingModule,
    FormsModule,
    RouterModule
  ],
  exports : [
    PlanoFormComponent,
    PlanoListaComponent
  ]
})
export class PlanoModule { }
