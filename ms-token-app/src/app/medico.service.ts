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
    return this.http.get<number>('http://localhost:8050/medico/getQtd');
  }
  
  buscarProximoPaciente(): Observable<Token> {
    return this.http.get<Token>('http://localhost:8050/medico/getProximo');
    
  }
  getFicha(tokenId: number): Observable<Ficha> {
    return this.http.get<Ficha>(`http://localhost:8050/medico/getFicha/${tokenId}`)
  }
  
  adicionarMedicacao(medicacao: Medicacao): Observable<any>{
    return this.http.post('http://localhost:8050/medico/adicionarMedicacao', medicacao)
  }

  salvarImprimirReceita(receita: Receita): Observable<any>{
    return this.http.post('http://localhost:8050/medico/salvarReceita', receita)
  }
  encaminharPacienteMedicacaoRaioX(encaminhamento: Encaminhamento): Observable<any> {
    return this.http.post('http://localhost:8050/medico/encaminharPaciente', encaminhamento);
    
  }
  getEncaminhamento(numToken: string): Observable<any>{
    return this.http.get<Encaminhamento>(`http://localhost:8050/medico/getEncaminhamento/${numToken}`)
  }
  encerrarAtendimento(token: Token) : Observable<any> {
   return this.http.post('http://localhost:8050/medico/encerrarAtendimento', token);
  }
  
}
