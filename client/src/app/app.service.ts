import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of, Subject } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { StavkaJelovnika, StavkaInterface } from '../app/model/stavka.model';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Korisnik } from './model/korisnik.model';
import { KorisnikDTO } from './DTO/KorisnikDTO';
import { StavkaDTO } from './DTO/StavkaDTO';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private currentUser = new BehaviorSubject<Korisnik | null>(null);

  cast = this.currentUser.asObservable();

  public loggedUser: Korisnik | null;

  constructor(private http: HttpClient) {
    this.loggedUser = null;
  }


  private stavkaUrl = 'http://localhost:8080/api/stavke';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  getStavka(id: number): Observable<StavkaJelovnika> {
    const url = `${this.stavkaUrl}/${id}`;

    return this.http
      .get<StavkaJelovnika>(url)
      .pipe(catchError(this.handleError<StavkaJelovnika>(`getStavka id=${id}`)));
  }

  getStavke(): Observable<StavkaJelovnika[]> {
    return this.http
    .get<StavkaJelovnika[]>(`http://localhost:8080/api/stavke`)
    .pipe(catchError(this.handleError<StavkaJelovnika[]>('getStavke', [])));
      
  }

  login(korisnikDTO: KorisnikDTO) {
    return this.http.post<any>(`http://localhost:8080/api/login`, korisnikDTO);
  }

  editKorisnik(newUser: any) {
    this.currentUser.next(newUser);
  }

  addStavka(stavka: StavkaDTO): Observable<StavkaJelovnika> {
    return this.http
      .post<StavkaJelovnika>(`http://localhost:8080/api/stavke`, stavka, this.httpOptions)
      .pipe(catchError(this.handleError<StavkaJelovnika>('addStavka')));

  }

  deleteStavka(id: number){
    return this.http.delete<any>(`http://localhost:8080/api/stavke/${id}`);
  }

  getStavkaById(id: number) {
    return this.http.get<StavkaJelovnika>(`http://localhost:8080/api/stavke`);
  }
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}

