import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TriagemPainelComponent } from './triagem/triagem-painel/triagem-painel.component';
import { GuichePainelComponent} from './guiche/guiche-painel/guiche-painel.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'triagem', component: TriagemPainelComponent },
  {path :'guiche', component : GuichePainelComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
