import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './entity/token';
import { Paciente } from './entity/paciente';


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

  salvarPaciente(paciente : Paciente): Observable<Paciente> {
    return this.http.post<Paciente>('http://localhost:8030/guiche/salvarPaciente', paciente);
  }

  atualizarPaciente(paciente: Paciente): Observable<Paciente>{
    return this.http.put<Paciente>('http://localhost:8030/guiche/atualizarPaciente', paciente)
  }
  encaminharToken(token: Token): Observable<Token> {
   return this.http.post<Token>('http://localhost:8030/guiche/encaminharToken', token)
    
  }
}
