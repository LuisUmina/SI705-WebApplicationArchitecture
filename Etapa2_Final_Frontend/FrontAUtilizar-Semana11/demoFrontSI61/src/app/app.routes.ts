import { Routes } from '@angular/router';
import { MovieComponent } from './components/movie/movie.component';
import path from 'path';
import { Component } from '@angular/core';
import { CreaeditamovieComponent } from './components/movie/creaeditamovie/creaeditamovie.component';

export const routes: Routes = [
    {
        path:'peliculas', component: MovieComponent,
        children:[
            {
                path:'nuevo', component: CreaeditamovieComponent
            }
        ]
    }
];
