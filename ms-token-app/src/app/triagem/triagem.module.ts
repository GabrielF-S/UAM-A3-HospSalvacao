import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


import { TriagemRoutingModule } from './triagem-routing.module';
import { TriagemPainelComponent } from './triagem-painel/triagem-painel.component';


@NgModule({
  declarations: [TriagemPainelComponent],
  imports: [
    CommonModule,
    TriagemRoutingModule,
    FormsModule,
  ]
})
export class TriagemModule { }
