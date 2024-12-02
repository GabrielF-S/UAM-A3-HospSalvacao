import { Component, OnInit } from '@angular/core';
import { Token } from 'src/app/token/token';
import { Paciente } from '../../pacientes/paciente';
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
  paciente: Paciente;
  sucesso: string;
  falha: string;

  constructor(
    private service: TriagemService,


  ) {
    this.token = new Token();
    this.ficha = new Ficha();
    this.paciente = new Paciente();
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
    console.log(this.ficha);
    this.service.enviarFicha(this.ficha).subscribe(response => {  
      this.resetCampos();
      this.getTamanhoFila();
      this.sucesso = "Paciente encaminhado para fila so Guichê"
      this.falha = null;
    }, erro => {
      this.falha = "Ocorreu um erro na solicitação"
      this.sucesso = null;
    });
  }

  buscarProximo() {
    this.sucesso = null;
    this.falha = null;
    this.service.buscarProximoPaciente().subscribe(
      response => {
        this.token = response;
        console.log(this.token);
      }, error => {
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
    );
  }

  resetCampos() {
    this.token = new Token();
    this.ficha = new Ficha();
    this.paciente = new Paciente();
    this.habilitarSintomas = false;
    this.pressao = "";
    this.temperatura = 0;
    this.sintomas = "";
  }

  
}
