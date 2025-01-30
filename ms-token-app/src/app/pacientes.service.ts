import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Paciente } from './entity/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacientesService {

  constructor(private http: HttpClient) {
    this.http.get
  }
  
  buscarPaciente(cpf: String): Observable<Paciente> {
    return this.http.get<any>(`http://localhost:8010/paciente/buscarRegistro/${cpf}`)
  
}

}
