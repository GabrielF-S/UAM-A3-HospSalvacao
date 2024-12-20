import { Component, OnInit } from '@angular/core';
import { RaioxService } from 'src/app/raiox.service';

@Component({
  selector: 'app-raiox-atendimento',
  templateUrl: './raiox-atendimento.component.html',
  styleUrls: ['./raiox-atendimento.component.css']
})
export class RaioxAtendimentoComponent implements OnInit {
  sucesso: string;
  falha: string;
  tamanhoFila: number = 0;

  constructor(
    private service: RaioxService,
  ) { }

  ngOnInit(): void {
  }


  buscarProximo() {
    this.sucesso = null;
    this.falha = null;
    this.service.buscarProximo().subscribe(
      response => {
        console.log(response);
      }, error => {
        this.falha = "Falha ao chamar proximo"
      }
    )
  }
}
