package pe.edu.upc.demosi61clase.servicesinterfaces;

import pe.edu.upc.demosi61clase.entities.Review;

import java.util.List;

public interface IReviewService {
    public void insert(Review review);
    public List<Review> list();
    public List<String[]> quantityReviewByMovie();
    public List<String[]> sumPoints();


}
