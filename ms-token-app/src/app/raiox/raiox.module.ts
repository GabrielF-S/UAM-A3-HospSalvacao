import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RaioxRoutingModule } from './raiox-routing.module';
import { RaioxAtendimentoComponent } from './raiox-atendimento/raiox-atendimento.component';


@NgModule({
  declarations: [RaioxAtendimentoComponent],
  imports: [
    CommonModule,
    RaioxRoutingModule
  ]
})
export class RaioxModule { }
