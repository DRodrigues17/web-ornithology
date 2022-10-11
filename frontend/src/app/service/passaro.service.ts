import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { CustomResponse } from '../interface/CustomResponse';
import { Passaro } from '../interface/Passaro';

@Injectable({providedIn: 'root'})
export class PassaroService {

  
  private readonly apiUrl = 'any';

  constructor(private http: HttpClient) {}

  passaros$ = <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/v1/passaro/list`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  findByName$ = (name: string) => <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/v1/passaro/get/nome/${name}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  findByNameIngles$ = (name: string) => <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/v1/passaro/get/nomeIngles/${name}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  findByNameLatin$ = (name: string) => <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/v1/passaro/get/nomeLatin/${name}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  findByFamilia$ = (name: string) => <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/v1/passaro/get/familia/${name}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  save$ = (passaro: Passaro) => <Observable<CustomResponse>>
  this.http.post<CustomResponse>(`${this.apiUrl}/v1/passaro/save`, passaro)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError (`Ocorreu um erro - codigo do erro: ${error.status}`);
  }
}
