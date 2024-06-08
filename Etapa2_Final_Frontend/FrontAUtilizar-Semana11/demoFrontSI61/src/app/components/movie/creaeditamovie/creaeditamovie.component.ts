import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input'; //-> Para usar el input (primer elemento que agregamos en el html)
import { MatButtonModule } from '@angular/material/button';
import { MovieService } from '../../../services/movie.service';
import { Movie } from '../../../models/movie';
import { Router } from '@angular/router';


@Component({
  selector: 'app-creaeditamovie',
  standalone: true,
  imports: [
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    CommonModule, //-> Trae todas las difertivas base (ngIf, ngFor, etc.)
    MatInputModule, //-> Para usar el input (primer elemento que agregamos en el html) No marca eror pero no compila
    MatButtonModule, //-> Para usar el boton (primer boton)
  ],
  templateUrl: './creaeditamovie.component.html',
  styleUrl: './creaeditamovie.component.css'
})
export class CreaeditamovieComponent implements OnInit{
  //Declaramos el formulario
  form:FormGroup=new FormGroup({});

  //Para el metodo aceptar(lo ultimo)
  movie:Movie=new Movie();


  //Declaramos la lista de generos que se mostrara en el form
  listaGeneros:{value:string, viewValue:string}[]=[
    {value:'Drama', viewValue:'Drama'},
    {value:'Terror', viewValue:'Terror'},
    {value:'Comedia', viewValue:'Comedia'},
    {value:'Romance', viewValue:'Romance'}
  ];

  //Inyectamos de dependencias con el constructor para que nos deje usar formBuilder
  //y el servicio de peliculas para poder hacer el metodo aceptar
  //Inyectamos el router para poder navegar hacia la lista de peliculas (el router que usamos es de tipo Agular router )
  constructor(private formBuilder:FormBuilder, private mS:MovieService, private router:Router){ }

  ngOnInit(): void{
    this.form=this.formBuilder.group({
      //Agregamos los campos del formulario
      nombre:['',Validators.required],
      genero:['',Validators.required],
      sinopsis:['',Validators.required],
      //En el siguiente valor voy a agregar mas validaciones 
      duracion:['',[Validators.required, Validators.min(60), Validators.max(180), Validators.pattern('^[0-9]*$')]],
      anio:['',Validators.required],
    })
  }
  //Una vez que inserte, quiero que haga una re direccion y actualice la data
  aceptar():void{
    if(this.form.valid){
      this.movie.titleMovie=this.form.value.nombre;
      this.movie.genderMovie=this.form.value.genero;
      this.movie.synopsisMovie=this.form.value.sinopsis;
      this.movie.durationMovie=this.form.value.duracion;
      this.movie.yearLaunchMovie=this.form.value.anio;
      //Hasta aqui el metodo ya incerto  -> this.mS.insert(this.movie);
      //Una vez que inserte, quiero que haga una re direccion y actualice la data
      this.mS.insert(this.movie).subscribe((data) =>{
        this.mS.list().subscribe((data)=>{
          this.mS.setList(data)
        })
      })
      //Ahora voy a hacer una variable que me permita navegar hacia la lista de peliculas, para ello necesito inyectar un variable de tipo router para la navegacion  
      this.router.navigate(['peliculas']);
    }
  }
}
