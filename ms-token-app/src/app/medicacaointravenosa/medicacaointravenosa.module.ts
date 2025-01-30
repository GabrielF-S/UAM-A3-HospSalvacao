import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MedicacaointravenosaRoutingModule } from './medicacaointravenosa-routing.module';
import { MedicacaoAtendimentoComponent } from './medicacao-atendimento/medicacao-atendimento.component';
import { FilaEsperaComponent } from './fila-espera/fila-espera.component';


@NgModule({
  declarations: [MedicacaoAtendimentoComponent, FilaEsperaComponent],
  imports: [
    CommonModule,
    MedicacaointravenosaRoutingModule
  ]
})
export class MedicacaointravenosaModule { }
