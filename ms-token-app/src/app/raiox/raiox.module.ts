import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { RaioxRoutingModule } from './raiox-routing.module';
import { RaioxAtendimentoComponent } from './raiox-atendimento/raiox-atendimento.component';


@NgModule({
  declarations: [RaioxAtendimentoComponent],
  imports: [
    CommonModule,
    RaioxRoutingModule,
    FormsModule
  ]
})
export class RaioxModule { }
