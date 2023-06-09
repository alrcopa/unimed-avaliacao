import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  usuarioLogado!: string ;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }


  logout(){
    this.authService.encerrarSessao();
    this.router.navigate(['/login'])
  }

}
