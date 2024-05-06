package pe.edu.upc.democlase.ServiceInterfaces;

import pe.edu.upc.democlase.Dtos.MovieDTO;
import pe.edu.upc.democlase.Entities.Movie;

import java.util.List;

// Las interfaces en java solo aceptan declaracion de metodos
public interface IMovieServiceInterface {
    public void insert(Movie movie);
    public List<Movie> list();
    public void delete(int id);
    public Movie listId(int id);
    public List<Movie> findByYearLaunchMovie(int anio);
}
