package pe.edu.upc.demosi61.dtos;

import jakarta.persistence.Column;

public class MovieDTO {
    private int idMovie;
    private String titleMovie;
    private String genderMovie;
    private String synopsisMovie;
    private float durationMovie;
    private int yearPublicationMovie;

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getGenderMovie() {
        return genderMovie;
    }

    public void setGenderMovie(String genderMovie) {
        this.genderMovie = genderMovie;
    }

    public String getSynopsisMovie() {
        return synopsisMovie;
    }

    public void setSynopsisMovie(String synopsisMovie) {
        this.synopsisMovie = synopsisMovie;
    }

    public float getDurationMovie() {
        return durationMovie;
    }

    public void setDurationMovie(float durationMovie) {
        this.durationMovie = durationMovie;
    }

    public int getYearPublicationMovie() {
        return yearPublicationMovie;
    }

    public void setYearPublicationMovie(int yearPublicationMovie) {
        this.yearPublicationMovie = yearPublicationMovie;
    }
}
