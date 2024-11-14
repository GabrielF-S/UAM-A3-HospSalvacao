import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common'


@Component({
  selector: 'app-sem-cadastro',
  templateUrl: './sem-cadastro.component.html',
  styleUrls: ['./sem-cadastro.component.css']
})
export class SemCadastroComponent implements OnInit {
 

  constructor(
    private location: Location,
    
  ) { 
    
  }

  ngOnInit(): void {
  }
  voltar() {
    this.location.back();
  }


}
