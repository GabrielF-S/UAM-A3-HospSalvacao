import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './entity/token'
import { Ficha } from './entity/ficha';

@Injectable({
  providedIn: 'root'
})
export class TriagemService {
  

  constructor(
    private http: HttpClient,
  ) {
    
  }

  buscarProximoPaciente(): Observable<Token> {
    return this.http.get<Token>('http://localhost:8020/triagem/token/getProximo');
    
  }

  getTamanhoFila(): Observable<number> {
    return this.http.get<number>('http://localhost:8020/triagem/token/getQtd');
  }

  enviarFicha(ficha: Ficha): Observable<Ficha> {
    return this.http.put<Ficha>('http://localhost:8020/triagem/ficha/save', ficha)
    
  }


}
