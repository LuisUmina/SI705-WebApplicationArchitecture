package pe.edu.upc.democlase.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pe.edu.upc.democlase.Entities.Review;
import pe.edu.upc.democlase.Repositories.IReviewRepository;
import pe.edu.upc.democlase.ServiceInterfaces.IReviewServiceInterface;

import java.util.List;

@Service
public class ReviewServiceImplement implements IReviewServiceInterface {

    @Autowired
    private IReviewRepository reviewRepository;

    @Override
    public void insert(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> list() {
        return reviewRepository.findAll();
    }

    @Override
    public List<String[]> quantityReviewByMovie() {
        return reviewRepository.quantityReviewByMovie();
    }

    @Override
    public List<String[]> sumPointsReviewByMovie() {
        return reviewRepository.sumPointsReviewByMovie();
    }


}
