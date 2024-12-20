import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TriagemPainelComponent } from './triagem/triagem-painel/triagem-painel.component';
import { GuichePainelComponent } from './guiche/guiche-painel/guiche-painel.component';
import { AtendimentoPainelComponent } from './atendimento/atendimento-painel/atendimento-painel.component';
import { MedicoAtendimentoComponent } from './medico/medico-atendimento/medico-atendimento.component';
import { RaioxAtendimentoComponent } from './raiox/raiox-atendimento/raiox-atendimento.component';
import { MedicacaoAtendimentoComponent } from './medicacaointravenosa/medicacao-atendimento/medicacao-atendimento.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'triagem', component: TriagemPainelComponent },
  { path: 'guiche', component: GuichePainelComponent },
  { path: 'painel', component: AtendimentoPainelComponent },
  { path: 'doutor', component: MedicoAtendimentoComponent },
  { path: 'raiox', component: RaioxAtendimentoComponent },
  { path: 'medicacao', component: MedicacaoAtendimentoComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
