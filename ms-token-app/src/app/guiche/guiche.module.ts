import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { GuicheRoutingModule } from './guiche-routing.module';
import { GuichePainelComponent } from './guiche-painel/guiche-painel.component';


@NgModule({
  declarations: [GuichePainelComponent],
  imports: [
    CommonModule,
    GuicheRoutingModule,
    FormsModule,
  ]
})
export class GuicheModule { }
