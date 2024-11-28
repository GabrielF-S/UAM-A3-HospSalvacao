import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './token/token'


@Injectable({
  providedIn: 'root'
})
export class GuicheService {

  constructor(
    private http : HttpClient,
  ) { }

  getTamanhoFila(): Observable<number>{
    return this.http.get<number>('http://localhost:8030/guiche/getQtd');
  }

  buscarProximoPaciente(): Observable<Token> {
    return this.http.get<Token>('http://localhost:8030/guiche/getProximo');
    
  }

}
