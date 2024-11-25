import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './token/token'

@Injectable({
  providedIn: 'root'
})
export class TriagemService {

  constructor(
    private http : HttpClient,
  ) { 
    
  }

  buscarProximoPaciente(): Observable<Token> {
    return this.http.get<Token>('http://localhost:8020/triagem/getProximo')
    
  }
}
