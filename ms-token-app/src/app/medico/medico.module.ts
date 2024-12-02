import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { MedicoRoutingModule } from './medico-routing.module';
import { MedicoAtendimentoComponent } from './medico-atendimento/medico-atendimento.component';


@NgModule({
  declarations: [MedicoAtendimentoComponent],
  imports: [
    CommonModule,
    MedicoRoutingModule,
    FormsModule,
  ]
})
export class MedicoModule { }
