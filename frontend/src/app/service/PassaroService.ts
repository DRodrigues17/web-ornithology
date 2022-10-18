import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { CustomResponse } from '../interface/CustomResponse';
import { Passaro } from '../interface/Passaro';

@Injectable({ providedIn: 'root' })
export class PassaroService {


  private readonly apiUrl = 'http://localhost:8080/v1/passaro';

  constructor(private http: HttpClient) { }

  passaros$ = <Observable<CustomResponse>>
    this.http.get<CustomResponse>(`${this.apiUrl}/list`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )

  findByName$ = (name: string) => <Observable<CustomResponse>>
    this.http.get<CustomResponse>(`${this.apiUrl}/get/nome/${name}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )

  findByNameIngles$ = (name: string) => <Observable<CustomResponse>>
    this.http.get<CustomResponse>(`${this.apiUrl}/get/nomeIngles/${name}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )

  findByNameLatin$ = (name: string) => <Observable<CustomResponse>>
    this.http.get<CustomResponse>(`${this.apiUrl}/get/nomeLatin/${name}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )

  findByFamilia$ = (name: string) => <Observable<CustomResponse>>
    this.http.get<CustomResponse>(`${this.apiUrl}/get/familia/${name}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )

  save$ = (passaro: Passaro) => <Observable<CustomResponse>>
    this.http.post<CustomResponse>(`${this.apiUrl}/save`, passaro)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(`Ocorreu um erro - codigo do erro: ${error.status}`);
  }
}
