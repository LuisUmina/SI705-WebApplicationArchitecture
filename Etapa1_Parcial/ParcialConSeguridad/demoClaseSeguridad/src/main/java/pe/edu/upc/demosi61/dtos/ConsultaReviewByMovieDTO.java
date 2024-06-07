package pe.edu.upc.demosi61.dtos;

public class ConsultaReviewByMovieDTO {
    private String titleMovie;
    private int quantityReview;

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public int getQuantityReview() {
        return quantityReview;
    }

    public void setQuantityReview(int quantityReview) {
        this.quantityReview = quantityReview;
    }
}
