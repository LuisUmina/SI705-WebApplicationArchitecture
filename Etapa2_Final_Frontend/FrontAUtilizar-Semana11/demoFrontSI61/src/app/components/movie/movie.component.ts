import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarmovieComponent } from './listarmovie/listarmovie.component';

@Component({
  selector: 'app-movie',
  standalone: true,
  imports: [
    RouterOutlet,
    ListarmovieComponent
  ],
  templateUrl: './movie.component.html',
  styleUrl: './movie.component.css'
})

//Se implementa la interfaz OnInit para que el componente se ejecute al inicio
export class MovieComponent implements OnInit{

  //Para hacer inyeccion de dependencias en angular, se utiliza el constructor
  //Las rutas son accesibles por todos los usuarios
  //Esta ruta me permite la navegacion entre componentes
  constructor(public route:ActivatedRoute) { }
  ngOnInit(): void { }
}
