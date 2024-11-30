import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AtendimentoService {

  constructor(
    private http : HttpClient,
  ) { }

  getStack(): Observable<any>{
    return this.http.get<any>(`http://localhost:8040/atendimento`)
  }
}
