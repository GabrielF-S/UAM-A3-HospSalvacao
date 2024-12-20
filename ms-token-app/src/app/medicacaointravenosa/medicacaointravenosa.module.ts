import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MedicacaointravenosaRoutingModule } from './medicacaointravenosa-routing.module';
import { MedicacaoAtendimentoComponent } from './medicacao-atendimento/medicacao-atendimento.component';


@NgModule({
  declarations: [MedicacaoAtendimentoComponent],
  imports: [
    CommonModule,
    MedicacaointravenosaRoutingModule
  ]
})
export class MedicacaointravenosaModule { }
