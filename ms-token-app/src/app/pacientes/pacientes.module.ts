import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PacientesRoutingModule } from './pacientes-routing.module';
import { GetPacienteComponent } from './get-paciente/get-paciente.component';


@NgModule({
  declarations: [GetPacienteComponent],
  imports: [
    CommonModule,
    PacientesRoutingModule
  ]
})
export class PacientesModule { }
