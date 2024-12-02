import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { TemplateModule } from './template/template.module';
import { PacientesModule } from './pacientes/pacientes.module';
import { FormsModule } from '@angular/forms';
import { TriagemModule } from './triagem/triagem.module';
import { GuicheModule } from './guiche/guiche.module';
import { AtendimentoModule } from './atendimento/atendimento.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { TokensService } from './tokens.service';
import { PacientesService } from './pacientes.service';
import { AtendimentoService } from './atendimento.service';
import { GuicheService } from './guiche.service'; 


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TemplateModule,
    PacientesModule,
    HttpClientModule,
    FormsModule,
    TriagemModule,
    GuicheModule,
    AtendimentoModule,
   
  ],
  providers: [
    TokensService,
    PacientesService,
    AtendimentoService,
    GuicheService,
  
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
