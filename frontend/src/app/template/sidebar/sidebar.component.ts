import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  usuarioLogado!: string ;

  constructor(

    private router: Router
  ) { }


  logout(){

    this.router.navigate(['/login'])
  }

}