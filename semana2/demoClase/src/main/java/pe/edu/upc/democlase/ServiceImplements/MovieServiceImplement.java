package pe.edu.upc.democlase.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.democlase.Entities.Movie;
import pe.edu.upc.democlase.Repositories.IMovieRepository;
import pe.edu.upc.democlase.ServiceInterfaces.IMovieServiceInterface;

import java.util.List;

@Service
public class MovieServiceImplement implements IMovieServiceInterface {

    // -> Control de inyección de dependencias
    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public void insert(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    @Override
    public void delete(int id) { movieRepository.deleteById(id); }

    @Override
    public Movie listId(int id) { return movieRepository.findById(id).orElse(new Movie()); } // -> Si no encuentra el id, devuelve un objeto vacío

    @Override
    public List<Movie> findByYearLaunchMovie(int anio) { return movieRepository.findByYearLaunchMovie(anio); } // -> Busca por año de lanzamiento

}
