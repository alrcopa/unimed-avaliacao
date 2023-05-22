import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './login/login.component';
import { AuthService } from './services/auth.service';
import { BeneficiarioService } from './services/beneficiario.service';
import { PlanoService } from './services/plano.service';
import { TokenInterceptor } from './services/token.interceptor';
import { TemplateModule } from './template/template.module';
import { BeneficiarioModule } from './view/beneficiario/beneficiario.module';
import { PlanoModule } from './view/plano/plano.module';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LayoutComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TemplateModule,
    PlanoModule,
    BeneficiarioModule
  ],
  providers: [
    BeneficiarioService,
    PlanoService,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
