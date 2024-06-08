import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../models/movie';
//Referencia al enviroment
const base_url=environment.base


@Injectable({
  providedIn: 'root'
})
export class MovieService {
  //Implementar el acceso hacia el controlador de movie
  //Hasta aqui tengo la url base de la api y le agrego la ruta del controlador de movie (requestMapping de movie)
  private url=`${base_url}/peliculas` 

  //utilizamos nuestro constructor para hacer la inyeccion de dependencias
  //Para hacer las peticions http necesitamos el modulo HttpClient
  //Tengo que ir al app.config.ts y agregar en providers -> provideHttpCliente(withFetch())
  constructor(private http:HttpClient) { }


  //Metodo para obtener todas las peliculas
  list(){
    //Hago la peticion get a la url de la api - tipo Movie[] es el tipo de dato que espero recibir segun el parametro de la funcion (url) 
    return this.http.get<Movie[]>(this.url);
  }

}
