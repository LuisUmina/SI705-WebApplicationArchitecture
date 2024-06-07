package pe.edu.upc.demosi61.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demosi61.entities.Review;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "select m.title_movie as Pelicula ,count(*) as Reviews\n" +
            "from Movie m inner join Review r\n" +
            "on m.id_movie=r.id_movie\n" +
            "group by m.title_movie",nativeQuery = true)
    List<String[]> quantityReviewByMovie();

    @Query(value="SELECT m.title_movie,SUM(r.points_review) FROM Movie m inner join " +
            "Review r on m.id_movie=r.id_movie \n" +
            "group by m.title_movie",nativeQuery = true)
    List<String[]> pointsByMovie();



}
