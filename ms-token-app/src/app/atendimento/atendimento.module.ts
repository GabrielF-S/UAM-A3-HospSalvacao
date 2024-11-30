import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AtendimentoRoutingModule } from './atendimento-routing.module';
import { AtendimentoPainelComponent } from './atendimento-painel/atendimento-painel.component';


@NgModule({
  declarations: [AtendimentoPainelComponent],
  imports: [
    CommonModule,
    AtendimentoRoutingModule,
    FormsModule
  ]
})
export class AtendimentoModule { }
