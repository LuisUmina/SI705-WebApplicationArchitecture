package pe.edu.upc.democlase.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.democlase.Entities.Review;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> { // -> JpaRepository<Entidad, Tipo de dato de la llave primaria>
    @Query(value = "SELECT m.title_movie AS Pelicula, COUNT(*) as cantidad \n" +
            "FROM movie m INNER JOIN review r ON m.id_movie = r.id_movie \n" +
            "GROUP BY m.title_movie", nativeQuery = true)
    public List<String[]> quantityReviewByMovie();


    @Query(value = "SELECT m.title_movie AS Pelicula, SUM(r.points_review) as suma\n" +
            "FROM movie m INNER JOIN review r ON m.id_movie = r.id_movie\n" +
            "GROUP BY m.title_movie", nativeQuery = true)
    public List<String[]> sumPointsReviewByMovie();

}
