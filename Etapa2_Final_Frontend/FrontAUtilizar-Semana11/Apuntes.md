
# SEMANA 10

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



# SEMANA 11

Vamos trabar los metodos insertar, actualizar y eliminar
============================
Primero vamos a modificar el estulo de la tabla listar, para ello usamos bostrap y agregamos el css del listar

Vamos a trabajar con boostrap y para ello traemos su link y lo agregamos en el archivo ```index.html```.
<!--https://getbootstrap.com/docs/5.0/getting-started/introduction/-->

```html
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
```

## Insertar
### Service
Agregamos el codigo de insertar en el service
```typescript
// Declaramos la variable
private listaCambio = new Subject<Movie[]>();

// Metodo para insertar
setList(listaNueva:Movie[]){
    this.listaCambio.next(listaNueva);
  }

  getList(){
    return this.listaCambio.asObservable();
  }
```
Apuntes: 
* __Subject:__ Un Subject en rxjs es una clase especial que actúa simultáneamente como un Observable y un Observer. 
    * __Observable:__
        * Un Observable es una fuente de datos que emite valores a lo largo del tiempo.
        * Los observadores pueden suscribirse a un Observable para recibir esos valores emitidos.
    * __Observer:__
        * Un Observer es un objeto que recibe notificaciones (valores, errores o la finalización) de un Observable.
* ```listaCambio.next(listaNueva)```: Emite el nuevo array de películas (listaNueva) a todos los observadores que están suscritos a listaCambio. Esto es útil para notificar a otras partes de la aplicación que la lista de películas ha cambiado.
* ```asObservable()```: Convierte el Subject a un Observable, permitiendo que otras partes de la aplicación se suscriban a los cambios sin poder emitir nuevos valores. Esto garantiza que solo el servicio pueda emitir valores, mientras que otros componentes pueden observar esos valores.

### Componente
Creamos el nuevo componente con el comando ```ng g c components/movie/creaeditamovie --skip-tests```.

Le definimos una ruta en  el ```app.routes.ts```. (es una ruta hija)

En el app.component.html agregamos un boton para redirigirnos a la ruta de insertar.

Como ya nos redirige al componente de registrar editar, vamos a trabajar en este componente.
#### Componente creaeditamovie



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
