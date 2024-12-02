import { Component, OnInit } from '@angular/core';
import { Paciente } from 'src/app/pacientes/paciente';
import { Token } from 'src/app/token/token';
import {GuicheService } from '../../guiche.service';
import { Endereco } from 'src/app/pacientes/endereco';


@Component({
  selector: 'app-guiche-painel',
  templateUrl: './guiche-painel.component.html',
  styleUrls: ['./guiche-painel.component.css']
})
export class GuichePainelComponent implements OnInit {

  tamanhoFila: number = 0;
  token: Token;
  paciente: Paciente;
  endereco: Endereco;
  cadastroOK: boolean = false;
  sucesso: string;
  falha: string;

  constructor(
    private service: GuicheService,
  ) { 
    this.token = new Token();
    this.paciente = new Paciente();
    this.endereco = new Endereco();

  }

  ngOnInit(): void {
    this.getTamanhoFila();
  }

  buscarProximo() {   
    this.sucesso = null;
    this.falha = null;
    this.service.buscarProximoPaciente().subscribe(response => {
      console.log(response);
      this.token = response;
    
      if (this.token.paciente != null) {
        this.paciente = this.token.paciente;
        if (this.paciente.endereco != null) {
          this.endereco = this.paciente.endereco;
          this.cadastroOK = true;
        }
        
      }
    }, erro => {
      this.falha = "Erro ao buscar";
    })
    this.getTamanhoFila();
  };

  getTamanhoFila() {
    this.service.getTamanhoFila().subscribe(
      response => {
        this.tamanhoFila = response;
      }, error => {
        this.tamanhoFila = 0;
      }
    )
  };

  salvarPaciente() {   
    this.sucesso = null;
    this.falha = null;
    this.paciente.endereco = this.endereco;
    console.log(this.paciente);
    if (this.token.id != 0) {
      this.service.salvarPaciente(this.paciente).subscribe(
      response => {
          this.token.paciente = response; 
        this.sucesso = "Cadastro do paciente salvo"  
        this.cadastroOK = true;
      }, erro => {
          this.falha = "Erro ao salvar paciente";
        }
    )
    }
    
  };
  atualizarPaciente() {
    this.sucesso = null;
    this.falha = null;
    if (this.paciente.endereco == null) {
      this.paciente.endereco = this.endereco;
    }
    this.service.atualizarPaciente(this.paciente).subscribe(
      response =>{
        this.sucesso = "Dados Atualizado com sucesso" 
      }, erro => {
        this.falha = "Erro ao atualizar paciente";
      }
    )
  };

  encaminharPaciente() {
    this.sucesso = null;
    this.falha = null;
    console.log(this.token);
    this.service.encaminharToken(this.token).subscribe(
      response => {
        this.sucesso = "Encaminhado para o medico";
        this.getTamanhoFila();
      }, erro => {
        this.falha = "Erro ao enviar";
      }

    )
    this.resetCampos();
  };

  
  resetCampos() {
    this.token = new Token;
    this.paciente = new Paciente();
    this.endereco = new Endereco();
    this.cadastroOK = false;
    
  }

}
