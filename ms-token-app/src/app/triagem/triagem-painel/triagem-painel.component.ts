import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Token } from 'src/app/token/token';

@Component({
  selector: 'app-triagem-painel',
  templateUrl: './triagem-painel.component.html',
  styleUrls: ['./triagem-painel.component.css']
})
export class TriagemPainelComponent implements OnInit {

  private token: Token;
  habilitarSintomas: boolean = false;

  constructor() {
    this.token = new Token();
   }

  ngOnInit(): void {
  }

  adiconarSintomas() {
    this.habilitarSintomas = true;
  }

  salvarEncaminhar() {
    
  }
  buscarProximo() {
    
  }

}
