import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GetPacienteComponent } from './get-paciente/get-paciente.component';
import { SemCadastroComponent } from './sem-cadastro/sem-cadastro.component';



const routes: Routes = [
  { path: 'pacienteCadastrado', component: GetPacienteComponent },
  {path: 'pacienteSemCadastrado', component: SemCadastroComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PacientesRoutingModule { }
