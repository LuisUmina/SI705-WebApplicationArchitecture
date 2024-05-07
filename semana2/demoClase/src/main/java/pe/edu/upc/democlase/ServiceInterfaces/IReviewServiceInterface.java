package pe.edu.upc.democlase.ServiceInterfaces;

import pe.edu.upc.democlase.Entities.Review;

import java.util.List;

public interface IReviewServiceInterface {
    public void insert(Review review);
    public List<Review> list();
    public List<String[]> quantityReviewByMovie();
    public List<String[]> sumPointsReviewByMovie();

}
