import { Component, OnInit } from '@angular/core';
import { Token } from 'src/app/entity/token';
import { Encaminhamento } from 'src/app/entity/encaminhamento';
import { MedicacaoinravenosaService } from 'src/app/medicacaoinravenosa.service';
import { MedicacaoVeia } from 'src/app/entity/medicacaoVeia';


@Component({
  selector: 'app-medicacao-atendimento',
  templateUrl: './medicacao-atendimento.component.html',
  styleUrls: ['./medicacao-atendimento.component.css']
})
export class MedicacaoAtendimentoComponent implements OnInit {
  sucesso: string;
  falha: string [];
  tamanhoFila: number = 0;
  encaminhamento: Encaminhamento;
  token: Token;

  medicacoesVeia: MedicacaoVeia;
  listaMedicacoesVeia: MedicacaoVeia[] = []; 
  listaMedicados: Encaminhamento[] = [];

  encaminhamentoSelecionado: Encaminhamento | null = null;

  constructor(
    private service: MedicacaoinravenosaService,
  ) { 
    this.encaminhamento = new Encaminhamento();
    this.token = new  Token();
  }

  ngOnInit(): void {
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
  
  buscarProximo() { 
    this.sucesso = null;
    this.falha = [];
    this.service.buscarProximoPaciente().subscribe(
      response => {
        
        this.encaminhamento = response;
        this.listaMedicacoesVeia = this.encaminhamento?.medicacaoIntravenosa || [];
        if (response.liberacao == null) {
          this.encaminhamento.liberacao = false;
        }
      }, error => {
        this.falha.push(error.error.message);
      }
    )
    this.getTamanhoFila();

  }
  receberMedicacao() {
      this.listaMedicados.push(this.encaminhamento);
      this.encaminhamento = new Encaminhamento();
      
    }
  
  selecionarEncaminhamento(encaminhamento: Encaminhamento) {
    this.encaminhamentoSelecionado = encaminhamento;
  }
  
  finalizarMedicacao(encaminhado: Encaminhamento) {
    let erro: boolean;
    encaminhado.liberacao = false;
    this.falha = [];
    for (let medicacao of encaminhado.medicacaoIntravenosa) {
      if (!medicacao.check) {
        this.falha.push(`Não é possivel concluir atendimento verifique se as medicações foram apliacadas: ` + medicacao.nome + " ");
          erro = true;
      }       
    }
    if (!erro) {
      this.falha = [];
      encaminhado.liberacao = true;
      this.sucesso = "Paciente {{encaminhamentoSelecionado.nomePaciente}} já pode ser liberado"
      // this.liberarPaciente(encaminhado)
      // this.listaMedicados = this.listaMedicados.filter(m => m !== encaminhado);
    } 
    
  }

  liberarPaciente(encaminhado: Encaminhamento) {
    this.falha = []

    if (encaminhado.liberacao) {
      this.listaMedicados = this.listaMedicados.filter(m => m !== encaminhado);
      this.service.encaminharPaciente(encaminhado).subscribe(
        response => { 
          this.sucesso = "Paciente {{encaminhamentoSelecionado.nomePaciente}} liberado"
        }, error =>{
          this.falha.push(error.error.message);
        }
      )
    } else {
      this.falha.push("Não é possivel liberar paciente ")
    }
    
    
  }
  

}
