import { Component, OnInit } from '@angular/core';
import { Paciente } from 'src/app/pacientes/paciente';
import { Token } from 'src/app/token/token';

@Component({
  selector: 'app-guiche-painel',
  templateUrl: './guiche-painel.component.html',
  styleUrls: ['./guiche-painel.component.css']
})
export class GuichePainelComponent implements OnInit {

  tamanhoFila: number = 0;
  token: Token;
  paciente: Paciente;

  constructor() { 
    this.token = new Token();
  }

  ngOnInit(): void {
  }

  buscarProximo() {
    
  }

}
