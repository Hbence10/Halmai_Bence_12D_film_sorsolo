import { Genre } from './../.model/genre.model';
import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MainService {
  genres = signal<Genre[]>([])

  constructor() { }
}
