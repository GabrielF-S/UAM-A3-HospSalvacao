import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './entity/token'
import { Ficha } from './entity/ficha';
import { Medicacao } from './entity/medicacao';
import { Receita } from './entity/receita';
import { Encaminhamento } from './entity/encaminhamento';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {
  
  constructor(
    private http: HttpClient,
  ) { }
  
  getTamanhoFila(): Observable<number> {
    return this.http.get<number>('http://localhost:8050/medico/token/getQtd');
  }
  
  buscarProximoPaciente(): Observable<Token> {
    return this.http.get<Token>('http://localhost:8050/medico/token/getProximo');
    
  }
  encerrarAtendimento(token: Token): Observable<any> {
   return this.http.post('http://localhost:8050/medico/token/encerrarAtendimento', token);
  }
  getFicha(tokenId: number): Observable<Ficha> {
    return this.http.get<Ficha>(`http://localhost:8050/medico/ficha/getFicha/${tokenId}`)
  }
  
 
  salvarImprimirReceita(receita: Receita): Observable<any>{
    return this.http.post('http://localhost:8050/medico/receita/salvarReceita', receita)

  }
  encaminharPacienteMedicacaoRaioX(encaminhamento: Encaminhamento): Observable<any> {
    return this.http.post('http://localhost:8050/medico/encaminhamento/encaminharPaciente', encaminhamento);
    
  }
  getEncaminhamento(numToken: string): Observable<any>{
    return this.http.get<Encaminhamento>(`http://localhost:8050/medico/encaminhamento/getEncaminhamento/${numToken}`)
  }
 
}
