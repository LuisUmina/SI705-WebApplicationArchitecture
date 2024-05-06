package pe.edu.upc.democlase.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.democlase.Entities.Movie;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    public List<Movie> findByYearLaunchMovie(int anio);
}
