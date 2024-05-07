package pe.edu.upc.demosi61.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demosi61.entities.Movie;
import pe.edu.upc.demosi61.repositories.IMovieRepository;
import pe.edu.upc.demosi61.servicesinterfaces.IMovieServiceInterface;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImplement implements IMovieServiceInterface {
    @Autowired
    private IMovieRepository mR;

    @Override
    public void insert(Movie movie) {
        mR.save(movie);
    }

    @Override
    public List<Movie> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idMovie) {
        mR.deleteById(idMovie);
    }

    @Override
    public Movie listarId(int idMovie) {
        return mR.findById(idMovie).orElse(new Movie());
    }

    @Override
    public List<Movie> findByYearPublication(int anio) {
        return mR.findByYearPublicationMovie(anio);
    }

    @Override
    public List<Movie> buscarGenero(String generos) {
        return mR.buscarGenero(generos);
    }
}
