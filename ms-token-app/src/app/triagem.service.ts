import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './token/token'
import { Ficha } from './triagem/ficha';

@Injectable({
  providedIn: 'root'
})
export class TriagemService {
  

  constructor(
    private http : HttpClient,
  ) { 
    
  }

  buscarProximoPaciente(): Observable<Token> {
    return this.http.get<Token>('http://localhost:8020/triagem/getProximo');
    
  }

  getTamanhoFila(): Observable<number> {
    return this.http.get<number>('http://localhost:8020/triagem/getQtd');
  }

  enviarFicha(ficha: Ficha): Observable<Ficha> {
    return this.http.post<Ficha>('http://localhost:8020/triagem/save', ficha)
    
  }
}
