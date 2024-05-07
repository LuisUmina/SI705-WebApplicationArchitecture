package pe.edu.upc.demosi61.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demosi61.entities.Movie;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    public List<Movie> findByYearPublicationMovie(int yearPublicationMovie);
    @Query("from Movie m where m.genderMovie=:genero")
    List<Movie> buscarGenero(@Param("genero") String generos);
}
