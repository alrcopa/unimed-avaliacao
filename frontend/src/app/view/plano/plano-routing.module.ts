import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from 'src/app/layout/layout.component';

import { PlanoFormComponent } from './plano-form/plano-form.component';
import { PlanoListaComponent } from './plano-lista/plano-lista.component';
import { AuthGuard } from 'src/app/services/auth.guard';

const routes: Routes = [
  { path: 'plano', component: LayoutComponent, canActivate: [AuthGuard], children: [
    { path: 'form', component: PlanoFormComponent },
    { path: 'lista', component: PlanoListaComponent },
    { path: '', redirectTo: '/plano/lista', pathMatch: 'full' }

  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlanoRoutingModule { }
