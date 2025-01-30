import { Component, OnInit } from '@angular/core';
import { MedicacaoService } from 'src/app/medicacao.service';
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
        this.listaMedicacoesVeia = this.encaminhamento.medicacaoIntravenosa;
        console.log(this.encaminhamento)
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
 

}
