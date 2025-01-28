import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Token } from './token/token';

@Injectable({
  providedIn: 'root'
})
export class MedicacaoService {

  constructor(
    private http: HttpClient,
  ) { }


  buscarProximoPaciente(): Observable<Token>{
     return this.http.get<Token>('http://localhost:8090/medicacao/getProximo');
    
  }

  getTamanhoFila(): Observable <number>{ 
     return this.http.get<number>('http://localhost:8090/medicacao/getQtd');;
  }
}
