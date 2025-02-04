import { Component, OnInit } from '@angular/core';
import { Encaminhamento } from 'src/app/entity/encaminhamento';
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
      }, error => {
        this.falha.push(error.error.message);
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
    let erro: boolean;
    this.falha = [];
    erro = false;
    for (let regiaoRaioX  of this.encaminhamento.regioesRaiox) {
      if (regiaoRaioX.check == false) {
        this.falha.push(`Verificar região` + regiaoRaioX.nome)
        erro = true
      } else {
        if (regiaoRaioX.diagnostico == null) {
          this.falha.push(`Verificar região` + regiaoRaioX.nome)
         erro = true
        } 
    } 
      
    }
    if (!erro) {
      this.service.encaminharPaciente(this.encaminhamento).subscribe(
      response => {
        this.sucesso = "Paciente encaminhado para Médico"
        this.falha = [];
      }, erro => {
       
        this.falha.push(erro.statusText)
      }
      )
      this.getTamanhoFila();
      this.resetCampos();
    }
    
    
  }



  resetCampos() {
    this.encaminhamento = new Encaminhamento();
  }
}
