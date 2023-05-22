import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from 'src/app/layout/layout.component';
import { BeneficiarioFormComponent } from './beneficiario-form/beneficiario-form.component';
import { BeneficiarioListaComponent } from './beneficiario-lista/beneficiario-lista.component';
import {AuthGuard} from "../../services/auth.guard";

const routes: Routes = [
  { path : 'beneficiario' , component: LayoutComponent, canActivate: [AuthGuard], children: [

    { path: 'form' , component: BeneficiarioFormComponent },
    { path: 'form/:id' , component: BeneficiarioFormComponent },
    { path: 'lista', component: BeneficiarioListaComponent },
    { path: '', redirectTo : '/beneficiario/lista', pathMatch: 'full' }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BeneficiarioRoutingModule { }
