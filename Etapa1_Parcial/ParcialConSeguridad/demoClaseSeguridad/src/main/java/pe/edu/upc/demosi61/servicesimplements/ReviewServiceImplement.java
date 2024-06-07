package pe.edu.upc.demosi61.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demosi61.entities.Review;
import pe.edu.upc.demosi61.repositories.IReviewRepository;
import pe.edu.upc.demosi61.servicesinterfaces.IReviewService;

import java.util.List;

@Service
public class ReviewServiceImplement implements IReviewService {
    @Autowired
    private IReviewRepository rS;

    @Override
    public void insert(Review review) {
        rS.save(review);
    }

    @Override
    public List<Review> list() {
        return rS.findAll();
    }

    @Override
    public List<String[]> quantityReviewByMovie() {
        return rS.quantityReviewByMovie();
    }

    @Override
    public List<String[]> pointsByMovie() {
        return rS.pointsByMovie();
    }
}
