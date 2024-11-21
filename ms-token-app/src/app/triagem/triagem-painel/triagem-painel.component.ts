import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Token } from 'src/app/token/token';
import { TriagemService } from '../../triagem.service';

@Component({
  selector: 'app-triagem-painel',
  templateUrl: './triagem-painel.component.html',
  styleUrls: ['./triagem-painel.component.css']
})
export class TriagemPainelComponent implements OnInit {

  private token: Token;
  habilitarSintomas: boolean = false;

  constructor(
    private service: TriagemService,

  ) {
    this.token = new Token();
   }

  ngOnInit(): void {
  }

  adiconarSintomas() {
    this.habilitarSintomas = true;
  }

  salvarEncaminhar() {
    
  }
  buscarProximo() {
    this.service.buscarProximoPaciente().subscribe(
      response => {
        this.token = response;
      }
    );
  }

}
