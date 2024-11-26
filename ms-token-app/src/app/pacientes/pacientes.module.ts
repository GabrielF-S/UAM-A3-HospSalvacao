import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { PacientesRoutingModule } from './pacientes-routing.module';
import { GetPacienteComponent } from './get-paciente/get-paciente.component';
import { SemCadastroComponent } from './sem-cadastro/sem-cadastro.component';
import { AtendimentosComponent } from './atendimentos/atendimentos.component';





@NgModule({
  declarations: [GetPacienteComponent, SemCadastroComponent, AtendimentosComponent],
  imports: [
    CommonModule,
    PacientesRoutingModule,
    FormsModule,
    
  ]
})
export class PacientesModule { }
