import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TriagemRoutingModule } from './triagem-routing.module';
import { TriagemPainelComponent } from './triagem-painel/triagem-painel.component';


@NgModule({
  declarations: [TriagemPainelComponent],
  imports: [
    CommonModule,
    TriagemRoutingModule
  ]
})
export class TriagemModule { }
