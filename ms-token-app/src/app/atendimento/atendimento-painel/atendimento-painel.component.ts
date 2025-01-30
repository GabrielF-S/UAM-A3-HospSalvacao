import { Component, OnInit , OnDestroy} from '@angular/core';
import { Token } from 'src/app/entity/token';
import { AtendimentoService } from '../../atendimento.service';


@Component({
  selector: 'app-atendimento-painel',
  templateUrl: './atendimento-painel.component.html',
  styleUrls: ['./atendimento-painel.component.css']
})
export class AtendimentoPainelComponent implements OnInit, OnDestroy {
  private intervalId: any;
  tokens: Token[] = [];
  sucesso: string;
  falha: string;

  constructor(
    private service: AtendimentoService,

  ) { }

  ngOnInit(): void {
    this.carregarStack();
    this.iniciarReloadPeriodico();
  };

  iniciarReloadPeriodico() {
  this.intervalId = setInterval(() => {
    this.recarregarDados();
  }, 5000);
};
  recarregarDados() {

  this.carregarStack();
  };
  
ngOnDestroy(): void { 
  if(this.intervalId){ clearInterval(this.intervalId); }
  };
  
  carregarStack() {
    this.service.getStack().subscribe(
      data => {
        this.tokens = data;
      }, error => {
        this.falha="Erro ao carregar a pilha" 
      });
  }
}
