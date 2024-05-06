package pe.edu.upc.democlase.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.democlase.Dtos.MovieDTO;
import pe.edu.upc.democlase.Entities.Movie;
import pe.edu.upc.democlase.ServiceInterfaces.IMovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController //-> AnotaciOn que indica que la clase es un controlador
@RequestMapping("/peliculas") //-> Anotación que indica la ruta base del controlador
public class MovieController {

    @Autowired //-> Anotación que indica que se inyectará una dependencia
    private IMovieService movieService;

    @PostMapping("/insertar") //-> AnotaciOn que indica la ruta del método
    public void insertar(@RequestBody MovieDTO movieDTO){ //-> Anotación que indica que el método recibe un objeto JSON
        ModelMapper d = new ModelMapper(); //-> Instancia de la clase ModelMapper
        Movie movie = d.map(movieDTO, Movie.class); //-> Mapeo de un objeto a otro
        movieService.insert(movie); //-> Llamada al método insert de la interfaz IMovieService
    }

    @GetMapping("/listar") //-> Anotacion que indica la ruta del método
    public List<MovieDTO> listar() { //-> Anotación que indica que el método recibe un objeto JSON
        return movieService.list().stream().map( y ->{
            ModelMapper d = new ModelMapper(); //-> Instancia de la clase ModelMapper
            return d.map(y, MovieDTO.class); //-> Mapeo de un objeto a otro
                }
        ).collect(Collectors.toList()); //-> Conversion de una lista a otra
    }
}
