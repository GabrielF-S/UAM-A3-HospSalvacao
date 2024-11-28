import { Component, OnInit } from '@angular/core';
import { Paciente } from 'src/app/pacientes/paciente';
import { Token } from 'src/app/token/token';
import {GuicheService } from '../../guiche.service';

@Component({
  selector: 'app-guiche-painel',
  templateUrl: './guiche-painel.component.html',
  styleUrls: ['./guiche-painel.component.css']
})
export class GuichePainelComponent implements OnInit {

  tamanhoFila: number = 0;
  token: Token;
  paciente: Paciente;

  constructor(
    private service: GuicheService,
  ) { 
    this.token = new Token();
    this.paciente = new Paciente();
  }

  ngOnInit(): void {
    this.getTamanhoFila();
  }

  buscarProximo() {
    this.service.buscarProximoPaciente().subscribe(response => {
      console.log(response);
      this.token = response;
      this.paciente = this.token.paciente;
      
    }, erro => {
      console.log("Erro", erro)
    })
    this.getTamanhoFila();
  }

  getTamanhoFila() {
    this.service.getTamanhoFila().subscribe(
      response => {
        this.tamanhoFila = response;
      }, error => {
        this.tamanhoFila = 0;
      }
    )
  }

}
