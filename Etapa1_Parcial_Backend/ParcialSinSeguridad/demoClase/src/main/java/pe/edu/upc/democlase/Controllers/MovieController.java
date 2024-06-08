package pe.edu.upc.democlase.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.democlase.Dtos.MovieDTO;
import pe.edu.upc.democlase.Entities.Movie;
import pe.edu.upc.democlase.ServiceInterfaces.IMovieServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController //-> AnotaciOn que indica que la clase es un controlador
@RequestMapping("/peliculas") //-> Anotación que indica la ruta base del controlador
public class MovieController {

    @Autowired //-> Anotación que indica que se inyectará una dependencia
    private IMovieServiceInterface movieServiceInterface;

    @PostMapping("/insertar") //-> AnotaciOn que indica la ruta del método
    public void insertar(@RequestBody MovieDTO movieDTO){ //-> Anotación que indica que el método recibe un objeto JSON
        ModelMapper d = new ModelMapper(); //-> Instancia de la clase ModelMapper
        Movie movie = d.map(movieDTO, Movie.class); //-> Mapeo de un objeto a otro
        movieServiceInterface.insert(movie); //-> Llamada al método insert de la interfaz IMovieServiceInterface
    }

    // -> HU extra
    @PutMapping("/modificar")
    public void modificar(@RequestBody MovieDTO movieDTO){
        ModelMapper d = new ModelMapper();
        Movie movie = d.map(movieDTO, Movie.class);
        movieServiceInterface.insert(movie);
    }


    @GetMapping("/listar") //-> Anotacion que indica la ruta del método
    public List<MovieDTO> listar() {
        return movieServiceInterface.list().stream().map( y ->{
            ModelMapper d = new ModelMapper(); //-> Instancia de la clase ModelMapper
            return d.map(y, MovieDTO.class); //-> Mapeo de un objeto a otro
                }
        ).collect(Collectors.toList()); //-> Conversion de una lista a otra
    }

    @DeleteMapping("/eliminar/{id}") //-> Anotación que indica la ruta del método
    public void eliminar(@PathVariable("id") int id){ //-> Anotación que indica que el método recibe un parámetro de la URL
        movieServiceInterface.delete(id); //-> Llamada al método delete de la interfaz IMovieServiceInterface
    }

    @GetMapping("/listarId/{id}") //-> Anotación que indica la ruta del método
    public MovieDTO listarId (@PathVariable("id") int id){ //-> Anotación que indica que el método recibe un parámetro de la URL
        ModelMapper d = new ModelMapper(); //-> Instancia de la clase ModelMapper
        MovieDTO movieDto = d.map(movieServiceInterface.listId(id), MovieDTO.class); //-> Mapeo de un objeto a otro
        return movieDto;
    }

    @GetMapping("/listarPorAnio") //-> Anotacion que indica la ruta del método
    public List<MovieDTO> findByYearLaunchMovie(@RequestParam int anio) {
        return movieServiceInterface.findByYearLaunchMovie(anio).stream().map( y ->{
                    ModelMapper d = new ModelMapper(); //-> Instancia de la clase ModelMapper
                    return d.map(y, MovieDTO.class); //-> Mapeo de un objeto a otro
                }
        ).collect(Collectors.toList()); //-> Conversion de una lista a otra
    }
}
