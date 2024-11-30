import { Component, OnInit } from '@angular/core';
import { Token } from 'src/app/token/token';
import {AtendimentoService } from '../../atendimento.service';

@Component({
  selector: 'app-atendimento-painel',
  templateUrl: './atendimento-painel.component.html',
  styleUrls: ['./atendimento-painel.component.css']
})
export class AtendimentoPainelComponent implements OnInit {
  tokens: Token[] = [];

  constructor(
    private service: AtendimentoService,
  ) { }

  ngOnInit(): void {
    this.carregarStack();
  }

  carregarStack() {
    this.service.getStack().subscribe(
      data => {
        this.tokens = data;
        
      }, error => {
        console.error('Erro ao carregar a pilha:', error);
      });
  }
  
}
