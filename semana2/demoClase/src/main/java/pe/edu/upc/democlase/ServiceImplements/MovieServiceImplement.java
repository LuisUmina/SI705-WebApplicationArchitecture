package pe.edu.upc.democlase.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.democlase.Entities.Movie;
import pe.edu.upc.democlase.Repositories.IMovieRepository;
import pe.edu.upc.democlase.ServiceInterfaces.IMovieService;

import java.util.List;

@Service
public class MovieServiceImplement implements IMovieService {

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
}
