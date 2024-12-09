import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './token/token'
import { Ficha } from './triagem/ficha';
import { Medicacao } from './pacientes/medicacao';

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

}
