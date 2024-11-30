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
      
      console.log("Pacientethis: " + this.paciente.id);
      
    }, erro => {
      console.log("Erro", erro)
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
    this.paciente.endereco = this.endereco;
    console.log(this.paciente);
    if (this.token.id != 0) {
      this.service.salvarPaciente(this.paciente).subscribe(
      response => {
        console.log(response)
        this.token.paciente = response;
        console.log(this.token)
        this.cadastroOK = true;
      }, erro => {
        console.log("Houve um erro", erro)
        }
    )
    }
    
  };
  atualizarPaciente() {
    if (this.paciente.endereco == null) {
      this.paciente.endereco = this.endereco;
    }
    this.service.atualizarPaciente(this.paciente).subscribe(
      response =>{
          console.log(response)
      }, erro => {
        console.log("erro: ", erro)
      }
    )
  };

  encaminharPaciente() {
    console.log(this.token);
    this.service.encaminharToken(this.token).subscribe(
      response => {
        this.sucesso = "Encaminhado apra o medico";
        console.log(response);
        this.getTamanhoFila();
      }, erro => {
        console.log("Houve um erro", erro);
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
