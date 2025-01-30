import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common'
import { Token } from 'src/app/entity/token';
import { TokenAtendimento} from '../../entity/tokenAtendimento';
import { TokensService } from '../../tokens.service';
import { Paciente } from '../../entity/paciente'



@Component({
  selector: 'app-atendimentos',
  templateUrl: './atendimentos.component.html',
  styleUrls: ['./atendimentos.component.css']
})
export class AtendimentosComponent implements OnInit {
  token: Token;
  tokenAtendimento: TokenAtendimento;
  paciente: Paciente;

  constructor(
    private location: Location,
    private tokenService: TokensService,
  ) {
    this.token = new Token();
    this.tokenAtendimento = new TokenAtendimento();
    this.paciente = new Paciente();
    
   }

  ngOnInit(): void {
  }
  voltar() {
    this.location.back();
  }

  gerarToken(tipoAtendimento: string) {
   
    this.tokenAtendimento.tipoAtendimento = tipoAtendimento;
    this.tokenService.gerarToken(this.tokenAtendimento)
      .subscribe(
        response => {
          this.token = response
        }
    );
    if (this.token.paciente == null) {
      this.paciente.nome = "Não Informado"
      this.token.paciente = this.paciente;
    }
    return this.token;
  }


}
