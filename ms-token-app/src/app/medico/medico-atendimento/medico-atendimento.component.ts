import { Component, OnInit } from '@angular/core';

import { MedicoService} from '../../medico.service'
import { Token } from 'src/app/token/token';
import { Ficha } from 'src/app/triagem/ficha';
import { Medicacao } from 'src/app/pacientes/medicacao';
import { Receita } from 'src/app/pacientes/receita';
import { MedicacaoVeia} from '../../pacientes/medicacaoVeia';
import { Encaminhamento } from 'src/app/pacientes/encaminhamento';
import { Regiao } from 'src/app/pacientes/regiao';

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
  regioesRaioX: Regiao[] = [];
  encaminhamento: Encaminhamento;
  regiao: Regiao;

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
       

      }, erro => {
        this.falha = erro.error.message;
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
        if (this.token.retorno) {
          this.verificarEncaminhamento(response.token.numToken)
        }
        this.falha = null;
        
      }, erro => {
        this.falha = erro.error.message;
      }
    )
    this.getTamanhoFila();
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
        this.falha = erro.error.message;
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
    this.regiao = new Regiao();
    this.regiao.nome = this.regiaoRaioX;
    this.regioesRaioX.push(this.regiao);
    this.regiaoRaioX = null;
  };

  removerRegiao(regiaoRaioX) {
    this.regioesRaioX = this.regioesRaioX.filter(r => r !== regiaoRaioX);
  }

  encaminharPaciente() {
    this.sucesso = null;
    this.falha = null;
    this.encaminhamento = new Encaminhamento();
    this.encaminhamento.numToken = this.token.numToken;
    this.encaminhamento.fichaId = this.ficha.id;
    this.encaminhamento.nomePaciente = this.token.paciente.nome;
    if (this.encaminharMedicao && this.encaminharRaioX) {
      this.encaminhamento.medicacaoIntravenosa = this.listaMedicacoesVeia;
      
      this.encaminhamento.regioesRaiox = this.regioesRaioX;
      
    } else {
      if (this.encaminharMedicao) {
        this.encaminhamento.medicacaoIntravenosa = this.listaMedicacoesVeia;
      } 
      if (this.encaminharRaioX) {
        console.log(this.regioesRaioX);
        this.encaminhamento.regioesRaiox = this.regioesRaioX;
        console.log(this.encaminhamento.regioesRaiox)
      }
    }
    this.service.encaminharPacienteMedicacaoRaioX(this.encaminhamento).subscribe(
      response => {
        this.sucesso = "Paciente encaminhado com sucesso"
        this.falha = null;
      }, erro => {
        this.falha = erro.error.message;
        this.sucesso = null;
      }
    )
    this.resetCampos();
    this.getTamanhoFila();
   
  };

  encerrarAtendimento() { 
    this.service.encerrarAtendimento(this.token).subscribe(
      response =>
      {
        this.sucesso = "Atendimento Encerrado";
        this.resetCampos();
      }, erro => {
        erro = erro.error.message;
      }

    )
  };
  verificarEncaminhamento(numToken : string) {
    this.service.getEncaminhamento(numToken).subscribe(
      response => {
        console.log(response);
        this.encaminhamento = response;
        this.regioesRaioX = this.encaminhamento.regioesRaiox;
        if (this.regioesRaioX != null) {
          this.encaminharRaioX = true;
        }
        this.listaMedicacoesVeia = this.encaminhamento.medicacaoIntravenosa;
        if (this.listaMedicacoesVeia != null) {
          this.encaminharMedicao = true;
        }

       }
     );

   
  }

  resetCampos() {

    this.token = new Token();
    this.ficha = new Ficha();
    this.medicacao = new Medicacao();
    this.receita = new Receita();
    this.medicacoesVeia = new MedicacaoVeia();
    this.encaminhamento = new Encaminhamento();

    this.medicacoes = [];
    this.listaMedicacoesVeia = []; 
    this.regioesRaioX = [];

    this.encaminharMedicao = false;
    this.encaminharRaioX = false;
    
  }
}
