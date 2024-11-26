import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { PacientesService } from '../../pacientes.service';
import { Paciente } from '../paciente';
import { TokenAtendimento} from '../../token/tokenAtendimento';
import { TokensService } from '../../tokens.service';
import { Token } from 'src/app/token/token';




@Component({
  selector: 'app-get-paciente',
  templateUrl: './get-paciente.component.html',
  styleUrls: ['./get-paciente.component.css']
})
export class GetPacienteComponent implements OnInit {

  token: Token;
  tokenAtendimento: TokenAtendimento;
  paciente: Paciente;
  erro: string;
  valorCpf: string = '';

  constructor(

    private location: Location,
    private service: PacientesService,
    private tokenService: TokensService,
  ) {
    this.paciente = new Paciente();
    this.token = new Token();
    this.tokenAtendimento = new TokenAtendimento();
  }

  ngOnInit(): void {
  }

  voltar() {
    this.location.back();
  }

  buscarRegitro() {
    
    this.service.buscarPaciente(this.valorCpf).subscribe(response => {
      this.paciente = response;
      this.erro = null;
      console.log(this.paciente)
    }, error => {
      console.log('Não localizado', error)
      this.erro = "Registro não lozalizado"
    });
  };

  gerarToken(tipoAtendimento: string) {
    console.log(tipoAtendimento)
   
    this.tokenAtendimento.tipoAtendimento = tipoAtendimento;
    this.tokenAtendimento.cpf = this.paciente.cpf;
    this.tokenService.gerarToken(this.tokenAtendimento)
      .subscribe(
        response => {
          this.token = response;
          console.log(this.token);
        }
      );
  };
}
