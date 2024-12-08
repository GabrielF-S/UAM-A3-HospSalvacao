import { Component, OnInit } from '@angular/core';

import { MedicoService} from '../../medico.service'
import { Token } from 'src/app/token/token';
import { Ficha } from 'src/app/triagem/ficha';
import { Medicacao } from 'src/app/pacientes/medicacao';

@Component({
  selector: 'app-medico-atendimento',
  templateUrl: './medico-atendimento.component.html',
  styleUrls: ['./medico-atendimento.component.css']
})
export class MedicoAtendimentoComponent implements OnInit {

  sucesso: string;
  falha: string;
  tamanhoFila: number = 0;
  token: Token;
  ficha: Ficha;
  medicacao: Medicacao;
  medicacoes: Medicacao[] = [];

  constructor(
    private service: MedicoService,
  ) {
    this.token = new Token();
    this.ficha = new Ficha();
    this.medicacao = new Medicacao();
   }

  ngOnInit(): void {
    this.getTamanhoFila();
  }

  buscarProximo() { 
    this.sucesso = null;
    this.falha = null;
    this.service.buscarProximoPaciente().subscribe(
      response => {
        this.token = response;
        console.log(response);
      }, error => {
        this.falha = "Erro ao buscar proximo"
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

  getFicha() {
    this.service.getFicha(this.token.id).subscribe(
      response => {
        this.ficha = response
        this.falha = null;
      }, erro => {
        this.falha = "Falha ao obter ficha"
      }
    )
  }

  AdicionarMedicacao() {

    this.medicacoes.push(this.medicacao)
    this.medicacao = new Medicacao();
    // this.service.adicionarMedicacao(this.medicacao).subscribe(
    //   response => {
    //     this.sucesso = "Medicação adicionada";
    //     this.falha = null;
    //     this.medicacoes = response;
    //     console.log(response);
    //   }, erro => {
    //     this.falha = "Falha ao adiconar medicaçao"
    //     this.sucesso = null;
    //   }
    // )
    
  }

  removerMedicacao(medicacao : Medicacao) {
    this.medicacoes = this.medicacoes.filter(m => m !== medicacao);
  }

  


}
