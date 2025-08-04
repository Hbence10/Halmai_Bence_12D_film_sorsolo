import { MainService } from './../../.services/main.service';
import { CommonModule } from '@angular/common';
import { Component, DestroyRef, inject, OnInit, signal } from '@angular/core';
import { Genre } from '../../.model/genre.model';
import { response } from 'express';

@Component({
  selector: 'app-generator-page',
  imports: [CommonModule,],
  templateUrl: './generator-page.component.html',
  styleUrl: './generator-page.component.css'
})
export class GeneratorPageComponent implements OnInit{
  destroyRef = inject(DestroyRef)
  mainService = inject(MainService)

  genres = signal<Genre[]>([])

  ngOnInit(): void {
    const subscribe = this.mainService.getAllGenre().subscribe({
      next: response => this.genres.set(response),
      error: errorMsg => console.log(errorMsg)
    })

    this.destroyRef.onDestroy(() => {
      subscribe.unsubscribe()
      console.log("GeneratorPageComponent destroyed!!!")
    })
  }

  selectGenre(id: number){

  }
}
