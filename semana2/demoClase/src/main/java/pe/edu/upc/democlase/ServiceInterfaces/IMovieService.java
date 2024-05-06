package pe.edu.upc.democlase.ServiceInterfaces;

import pe.edu.upc.democlase.Entities.Movie;

import java.util.List;

// Las interfaces en java solo aceptan declaracion de metodos
public interface IMovieService {
    public void insert(Movie movie);
    public List<Movie> list();

}
