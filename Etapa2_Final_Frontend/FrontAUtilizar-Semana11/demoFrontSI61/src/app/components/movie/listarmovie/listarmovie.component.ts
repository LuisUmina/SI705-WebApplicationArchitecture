import { Component, OnInit } from '@angular/core';
//TABLE
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { Movie } from '../../../models/movie';
import { MovieService } from '../../../services/movie.service';

@Component({
  selector: 'app-listarmovie',
  standalone: true,
  imports: [
    //TABLE
    MatTableModule
  ],
  templateUrl: './listarmovie.component.html',
  styleUrl: './listarmovie.component.css'
})
export class ListarmovieComponent implements OnInit{
  // Aqui se coloca el nombre a cada elemento de la tabla / En este caso no se esta mostrando la sinopsis
  displayedColumns: string[] = [
    'idMovie', 
    'titleMovie', 
    'genderMovie', 
    'durationMovie', 
    'yearLaunchMovie'
    ];

    //Aqui declaramos el datasource que se va a mostrar en la tabla
    //Indicamos que va a traer todos los datos de la entidad movie y instanciamos
    dataSource:MatTableDataSource<Movie>=new MatTableDataSource<Movie>()

    //Para que este datasource se muestre en la tabla, debemos llenarlo con datos, para ello accedere a mi service mediante el contructor
    constructor(private mS:MovieService){}
    
    //En el ngOnInit llenamos el datasource con los datos de la entidad movie
    //Este metodo, es el metodo que se ejecuta justo despues del contructor
    ngOnInit(): void {
      //La lInea actualiza dataSource con los datos obtenidos del servicio mS usando una suscripciOn para mostrar los datos en la tabla de Angular Material.
      this.mS.list().subscribe((data) => (this.dataSource = new MatTableDataSource(data)))

      //Esta linea se agrega apra que se actualice la tabla cada vez que se inserte un nuevo registro
      this.mS.getList().subscribe((data)=> {this.dataSource = new MatTableDataSource(data)})
    }
}
