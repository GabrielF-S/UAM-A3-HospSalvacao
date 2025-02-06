import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenAtendimento } from './entity/tokenAtendimento';
import { Token } from './entity/token';
import { Paciente } from './entity/paciente'

@Injectable({
  providedIn: 'root'
})
export class TokensService {
  constructor(
    private http: HttpClient
  ) {
    this.http.get;
  }
  

  gerarToken(tokenAtendimento: TokenAtendimento): Observable<Token> {
    return this.http.post<Token>('http://localhost:8010/token/token/gerarFicha', tokenAtendimento);
    
  }
}
