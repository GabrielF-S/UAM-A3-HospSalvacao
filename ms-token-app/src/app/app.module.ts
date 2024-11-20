import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component';
import { PacientesModule } from './pacientes/pacientes.module';
import { TokensService } from './tokens.service';
import { PacientesService } from './pacientes.service';
import { FormsModule } from '@angular/forms';
import {TriagemModule } from './triagem/triagem.module'

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

  ],
  providers: [
    TokensService,
    PacientesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
