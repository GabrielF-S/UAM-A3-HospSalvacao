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
    this.http.get
  }

  buscarProximoPaciente(): Observable<any> {
    return this.http.get('http://localhost:8020/triagem/getProximo')
    
  }
}
