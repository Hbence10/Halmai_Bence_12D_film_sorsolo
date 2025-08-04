import { HttpClient } from '@angular/common/http';
import { Genre } from './../.model/genre.model';
import { inject, Injectable, signal } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MainService {
  private http = inject(HttpClient)
  constructor() { }

  getAllGenre(): Observable<Genre[]>{
    return this.http.get<Genre[]>("http://localhost:8080/genres")
  }
}
