package pe.edu.upc.demosi61.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demosi61.entities.Movie;

import java.time.LocalDate;
import java.util.List;

public interface IMovieServiceInterface {
    public void insert(Movie movie);

    public List<Movie> list();

    public void delete(int idMovie);

    public Movie listarId(int idMovie);

    List<Movie> findByYearPublication(int anio);

    List<Movie> buscarGenero( String generos);

}
