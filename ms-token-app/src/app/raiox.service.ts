import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RaioxService {

  constructor(private http: HttpClient) { }
  
  buscarProximo(): Observable<any>{
    return this.http.get<any>('http://localhost:8060/raiox/getProximo')
  }
}
