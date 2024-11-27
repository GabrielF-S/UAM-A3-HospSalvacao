import { Component, OnInit } from '@angular/core';
import { Token } from 'src/app/token/token';
import {Paciente } from '../../pacientes/paciente';
import { TriagemService } from '../../triagem.service';
import { Ficha } from '../ficha';




@Component({
  selector: 'app-triagem-painel',
  templateUrl: './triagem-painel.component.html',
  styleUrls: ['./triagem-painel.component.css']
})
export class TriagemPainelComponent implements OnInit {

  token: Token;
  habilitarSintomas: boolean = false;
  tamanhoFila: number = 0;
  pressao: string;
  temperatura: number;
  sintomas: string;
  ficha: Ficha;


  constructor(
    private service: TriagemService,

  ) {
    this.token = new Token();
    this.ficha = new Ficha();
   }

  ngOnInit(): void {
    this.getTamanhoFila();
  }

  adiconarSintomas() {
    this.habilitarSintomas = true;
  }

  salvarEncaminhar() {
    this.ficha.token = this.token;
    this.ficha.pressao = this.pressao;
    this.ficha.sintomas = this.sintomas;
    this.ficha.temperatura = this.temperatura;
    console.log(this.ficha)
    this.service.enviarFicha(this.ficha).subscribe(response => {
      console.log('success');
      this.ngOnInit();
    }, erro => {
      console.log("ocorreu um erro", erro)
    }

    );
    
    
  }
  buscarProximo() {
    this.service.buscarProximoPaciente().subscribe(
      response => {
        this.token = response;
        console.log(this.token)
      }, error=> {
        console.error('Erro ao buscar o próximo paciente:', error);
      }
    );
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
