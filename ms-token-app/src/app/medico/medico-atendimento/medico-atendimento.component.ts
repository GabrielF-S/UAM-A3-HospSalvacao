import { Component, OnInit } from '@angular/core';

import { MedicoService} from '../../medico.service'
import { Token } from 'src/app/token/token';
import { Ficha } from 'src/app/triagem/ficha';
import { Medicacao } from 'src/app/pacientes/medicacao';
import { Receita } from 'src/app/pacientes/receita';
import { MedicacaoVeia} from '../../pacientes/medicacaoVeia';

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
  receita: Receita;
  medicacoesVeia: MedicacaoVeia;
  listaMedicacoesVeia: MedicacaoVeia[] =[]; 
  encaminharMedicao: boolean;
  encaminharRaioX: boolean;
  regiaoRaioX: string;
  regioesRaioX: string[] = [];

  constructor(
    private service: MedicoService,
  ) {
    this.token = new Token();
    this.ficha = new Ficha();
    this.medicacao = new Medicacao();
    this.receita = new Receita();
    this.medicacoesVeia = new MedicacaoVeia();
    
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
    
  }

  removerMedicacao(medicacao : Medicacao) {
    this.medicacoes = this.medicacoes.filter(m => m !== medicacao);
  }

  
  salvarImprimir() {
    this.receita.numToken = this.token.numToken;
    this.receita.fichaId = this.ficha.id;
    this.receita.medicacoes = this.medicacoes;
    this.receita.nomePaciente = this.token.paciente.nome;

    this.service.salvarImprimirReceita(this.receita).subscribe(
      response => {
        this.sucesso = "Registro Salvo"
        this.falha = null;
      }, erro => {
        this.falha = "Erro ao adicinar medicação"
        this.sucesso = null;
      }
    )
  }

  AdicionarMedicacaoVeia() {
    this.listaMedicacoesVeia.push(this.medicacoesVeia);
    this.medicacoesVeia = new MedicacaoVeia();
    
  }

  removerMedicacaoVeia(medicacoesVeia) {
    this.listaMedicacoesVeia = this.listaMedicacoesVeia.filter(m => m !== medicacoesVeia);
  }


  AdicionarRaioX() { 
    this.regioesRaioX.push(this.regiaoRaioX);
    this.regiaoRaioX = null;
  };

  removerRegiao(regiaoRaioX) {
    this.regioesRaioX = this.regioesRaioX.filter(r => r !== regiaoRaioX);
  }

  encerrarAtendimento() { };

  encaminharPaciente() { };

}
