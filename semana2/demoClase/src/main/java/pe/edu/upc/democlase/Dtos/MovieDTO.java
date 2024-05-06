package pe.edu.upc.democlase.Dtos;

public class MovieDTO {
    // -> Atributos
    private Integer idMovie;
    private String titleMovie;
    private String genderMovie;
    private String synopsisMovie;
    private Integer durationMovie;
    private Integer yearLaunchMovie;

    // -> Setters y Getters
    public Integer getIdMovie() { return idMovie; }
    public void setIdMovie(Integer idMovie) { this.idMovie = idMovie; }
    public String getTitleMovie() { return titleMovie; }
    public void setTitleMovie(String titleMovie) { this.titleMovie = titleMovie; }
    public String getGenderMovie() { return genderMovie; }
    public void setGenderMovie(String genderMovie) { this.genderMovie = genderMovie; }
    public String getSynopsisMovie() { return synopsisMovie; }
    public void setSynopsisMovie(String synopsisMovie) { this.synopsisMovie = synopsisMovie; }
    public Integer getDurationMovie() { return durationMovie; }
    public void setDurationMovie(Integer durationMovie) { this.durationMovie = durationMovie; }
    public Integer getYearLaunchMovie() { return yearLaunchMovie; }
    public void setYearLaunchMovie(Integer yearLaunchMovie) { this.yearLaunchMovie = yearLaunchMovie; }
}
