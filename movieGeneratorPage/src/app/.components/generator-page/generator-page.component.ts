import { CommonModule } from '@angular/common';
import { MainService } from './../../.services/main.service';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-generator-page',
  imports: [CommonModule,],
  templateUrl: './generator-page.component.html',
  styleUrl: './generator-page.component.css'
})
export class GeneratorPageComponent {
  mainService = inject(MainService)
  router = inject(Router)
  amount: number = 0;
  selectedGenres: string[] = []


  generateList(){
    this.router.navigate([""])
  }
}
