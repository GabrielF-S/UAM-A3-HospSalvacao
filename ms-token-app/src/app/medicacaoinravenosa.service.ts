import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from './entity/token';
import { Encaminhamento } from './entity/encaminhamento';

@Injectable({
  providedIn: 'root'
})
export class MedicacaoinravenosaService {
  

  constructor(private http: HttpClient,
    
  ) {
    
   }

  buscarProximoPaciente(): Observable<Encaminhamento>{
    return this.http.get<Encaminhamento>('http://localhost:8090/medicacao/getProximo');
   
 }

 getTamanhoFila(): Observable <number>{ 
    return this.http.get<number>('http://localhost:8090/medicacao/getQtd');
 }
  
 encaminharPaciente(encaminhado: Encaminhamento): Observable<any> {
  return this.http.post<any>('http://localhost:8090/medicacao/encaminharPaciente', encaminhado);
}
}
