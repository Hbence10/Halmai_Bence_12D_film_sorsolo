import { GeneratorPageComponent } from './.components/generator-page/generator-page.component';
import { HomePageComponent } from './.components/home-page/home-page.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: "homePage",
    title: "home page",
    component: HomePageComponent
  },
  {
    path: "",
    redirectTo: "homePage",
    pathMatch: "full"
  },
  {
    path: "generatorPage",
    component: GeneratorPageComponent
  }
];
