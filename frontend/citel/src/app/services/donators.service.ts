import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { DonatorsPerStateModel } from '../models/donators-states-model';

@Injectable({
  providedIn: 'root'
})
export class DonatorsService {
  private donatorApi: string = 'http://127.0.0.1:8080'

  private http = inject(HttpClient)

  public getDonatorsPerState(): Observable<DonatorsPerStateModel[]> {    
    return this.http.get<DonatorsPerStateModel[]>(this.donatorApi + '/contagem')
  }

  // public getAvgImcAge(idadeInicial: number, idadeFinal: number): number {
  //   let params = new HttpParams();
  //   params.append("idadeInicial", idadeInicial);
  //   params.append("idadeFinal", idadeFinal);
  //   return this.http.get(this.donatorApi + '/imc-idade', params)
  // }

  // public getObesesPerGender(sexo: string): number {
  //   let params = new HttpParams();
  //   params.append("sexo", sexo)
  //   return this.http.get(this.donatorApi + '/obesos-sexo', params)
  // }

  // public getAvgAgePerType(tipo: string): number {
  //   let params = new HttpParams();
  //   params.append("tipo", tipo)
  //   return this.http.get(this.donatorApi + '/tipos-idade', params)
  // }

  // public getReceivers(tipo: string): number {
  //   let params = new HttpParams();
  //   params.append("tipo", tipo)
  //   return this.http.get(this.donatorApi + '/receptores', params)
  // }
}
