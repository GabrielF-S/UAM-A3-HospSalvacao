import { Component, OnInit } from '@angular/core';
import { MedicacaoService } from 'src/app/medicacao.service';
import { Token } from 'src/app/token/token';

@Component({
  selector: 'app-medicacao-atendimento',
  templateUrl: './medicacao-atendimento.component.html',
  styleUrls: ['./medicacao-atendimento.component.css']
})
export class MedicacaoAtendimentoComponent implements OnInit {
  sucesso: string;
  falha: string;
  tamanhoFila: number = 0;

    token: Token;

  constructor(
    private service: MedicacaoService,
  ) { }

  ngOnInit(): void {
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

}
