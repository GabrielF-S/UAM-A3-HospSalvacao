import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Encaminhamento } from './pacientes/encaminhamento';

@Injectable({
  providedIn: 'root'
})
export class RaioxService {

  constructor(private http: HttpClient) { }

  getTamanhoFila(): Observable<number> {
    return this.http.get<number>('http://localhost:8060/raiox/getQtd');
  }

  
  buscarProximo(): Observable<any>{
    return this.http.get<any>('http://localhost:8060/raiox/getProximo')
  }
  encaminharPaciente(encaminhamento: Encaminhamento): Observable<any>{
    return this.http.post('http://localhost:8060/raiox/encaminharPaciente', encaminhamento);
  }
}
