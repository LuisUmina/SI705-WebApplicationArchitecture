
DESARROLLO DEL PROYECTO
============================

## Conectar Angular con el backend
Sobre la carpeta ```src``` agregamos la carpeta ```environments``` y dentro de este agregamos el archivo ```environment.ts``` con el siguiente contenido:

```typescript
export const environment={
    production:false,
    base:"http://localhost:8080"
}
```

## Oraganización de la aplicación
Dentro de app vamos a crear 3 carpetas, en estas carpetas vamos a ir organizando todos los elementos de nuestra aplicación.
Agregamos las carpetas ```components```, ```services``` y ```models```.
 ### Trabajamos con los MODELS
 Dentro de la carpeta ```models``` vamos a crear un archivo por cada modelo que tengamos en nuestra aplicación (ejm. movie.ts).
 Colocamos las variables que tenemos en nuestro backend y las escribimos tal cual en el archivo de modelo, pero en formato de clase de typescript.
 ```typescript
export class Movie{
    idMovie:number=0
    titleMovie:string=""
    genderMovie:string=""
    synopsisMovie:string=""
    durationMovie:number=0
    yearLaunchMovie:string=""
}
```

 ### Trabajamos con los SERVICES
 Esta carpeta será creada con comando de angular, ```ng g s services/movie --skip-tests```. Pero previamente tengo que ingresar a la carpeta del proyecto con ```cd nombreProyecto```.
 
 ```bash
ng g s services/movie --skip-test
```

 ### Trabajamos con los COMPONENTS
 Esta carpeta será creada con comando de angular, ```ng g c components/movie --skip-tests```. Pero previamente tengo que ingresar a la carpeta del proyecto con ```cd nombreProyecto```.
 
 ```bash
ng g c components/movie --skip-tests
```
 #### Dentro de COMPONENT movie voy a crear otro component
 Esta carpeta será creada con comando de angular, ```ng g c components/movie/listarmovie --skip-tests```.
 
 ```bash
ng g c components/movie/listarmovie --skip-tests
```
 
 ### Ahora enlacemos (hacia movie y luego hacia listarmovie)
En el app.component.html vamos a agregar un menu de tipo angular material.
Como para agregar el menu utilicé elementos de angular material, debo de agregar este mismo al proyecto con el siguiente comando en la terminal.```ng add @angular/material``` (Ahora ya puedo ingresar los import que me solicita el archivo de ```app.component.ts```).
* Ojo: En ocaciones falta importar el button y no marca error!!!!

```html
//MENU
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';

...

@Component({
  ...
  imports: [
    RouterOutlet,
    //MENU
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatButtonModule
  ],
  ...
})
....
```
 ### Definir rutas
 Trabajamos en el component movie (listar movie tambien)

Definimos las rutas en el archivo ```app.routes.ts```.
* Ojo: En mi HTML donde uso el router Link  ```app.componente.html```, tengo que importarlo a pesar de que no me de error

 ```typescript
export const routes: Routes = [
    {
        path:'peliculas', component: MovieComponent
    }
];
```
 Trabajamos en el component listarmovie 



MÁS COMANDOS DE ANGULAR
============================
* Crear un nuevo proyecto de angular
    * ```ng new nombreProyecto```
    * ```->Yes```
    * ```->CSS```
* Ejecutar el proyecto
    * ```ng s``` o ```ng serve```
* Agregar Angular Material al proyecto
    * ```ng add @angular/material```
    * ```->Yes```
    * ```->Indigo/Pink``` (se puede elegir otro)
    * ```->Yes```
    * ```->Yes```
