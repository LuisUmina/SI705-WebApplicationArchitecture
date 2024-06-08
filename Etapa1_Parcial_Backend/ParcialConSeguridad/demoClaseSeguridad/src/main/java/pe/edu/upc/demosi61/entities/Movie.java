package pe.edu.upc.demosi61.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovie;
    @Column(name = "titleMovie",nullable = false,length = 40)
    private String titleMovie;
    @Column(name = "genderMovie",nullable = false,length = 30)
    private String genderMovie;
    @Column(name = "synopsisMovie",nullable = false,length = 370)
    private String synopsisMovie;
    @Column(name = "durationMovie",nullable = false)
    private float durationMovie;
    @Column(name = "yearPublicationMovie",nullable = false)
    private int yearPublicationMovie;

    public Movie() {
    }

    public Movie(int idMovie, String titleMovie, String genderMovie, String synopsisMovie, float durationMovie, int yearPublicationMovie) {
        this.idMovie = idMovie;
        this.titleMovie = titleMovie;
        this.genderMovie = genderMovie;
        this.synopsisMovie = synopsisMovie;
        this.durationMovie = durationMovie;
        this.yearPublicationMovie = yearPublicationMovie;
    }

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
