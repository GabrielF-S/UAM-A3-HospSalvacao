import { Component, OnInit } from '@angular/core';
import { Encaminhamento } from 'src/app/pacientes/encaminhamento';
import { RaioxService } from 'src/app/raiox.service';


@Component({
  selector: 'app-raiox-atendimento',
  templateUrl: './raiox-atendimento.component.html',
  styleUrls: ['./raiox-atendimento.component.css']
})
export class RaioxAtendimentoComponent implements OnInit {
  sucesso: string;
  falha: string [];
  tamanhoFila: number = 0;
  encaminhamento: Encaminhamento;
  erro: boolean;

  constructor(
    private service: RaioxService,

   
  ) { 
    this.encaminhamento = new Encaminhamento();
    this.encaminhamento.regioesRaiox = [];
    this.falha = [];
  }

  ngOnInit(): void {
    this.getTamanhoFila();
  }


  buscarProximo() {
    this.sucesso = null;
    this.falha = [];
    this.service.buscarProximo().subscribe(
      response => {
        this.encaminhamento = response;
        console.log(this.encaminhamento)  
      }, error => {
        this.falha.push("Falha ao chamar proximo");
      }
    )
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

  encaminharPaciente() {
    this.falha = [];
    this.erro = false;
    for (let regiaoRaioX  of this.encaminhamento.regioesRaiox) {
      if (regiaoRaioX.check == false) {
        this.falha.push(`Verificar região` + regiaoRaioX.nome)
        this.erro = true
      } else {
        if (regiaoRaioX.diagnostico == null) {
          this.falha.push(`Verificar região` + regiaoRaioX.nome)
          this.erro = true
      } 
    } 
      
    }
    if (!this.erro) {
      this.service.encaminharPaciente(this.encaminhamento).subscribe(
      response => {
        this.sucesso = "Paciente encaminhado para Médico"
        this.falha = [];
      }, erro => {
       
        this.falha.push(erro.statusText)
      }
    )
    }
    
    
  }
}
