package pe.edu.upc.democlase.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ANOTACIONES
@Entity //-> Para que sepa que es una entidad
@Table(name = "Movie") //-> Para que sepa que es una tabla de la BD
@Data //-> Para que cree los getters y setters
@AllArgsConstructor //-> Para que cree el constructor con todos los atributos
@NoArgsConstructor //-> Para que cree el constructor vacío

public class Movie {
    @Id //-> Para que sepa que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //-> Para que se auto genere y sea autoincrementable
    private Integer idMovie;

    @Column(name = "titleMovie", nullable = false, length = 25) //-> Para que sepa que es una columna con nombre titleMovie, no puede ser nulo y tiene un tamaño de 25 caracteres
    private String titleMovie;

    @Column(name = "genderMovie", nullable = false, length = 20) //-> Para que sepa que es una columna con nombre titleMovie, no puede ser nulo y tiene un tamaño de 20 caracteres
    private String genderMovie;

    @Column(name = "synopsisMovie", nullable = false, length = 300) //-> Para que sepa que es una columna con nombre titleMovie, no puede ser nulo y tiene un tamaño de 300 caracteres
    private String synopsisMovie;

    @Column(name = "durationMovie", nullable = false) //-> Para que sepa que es una columna con nombre titleMovie y no puede ser nulo
    private Integer durationMovie;

    @Column(name = "yearLaunchMovie", nullable = false) //-> Para que sepa que es una columna con nombre titleMovie y no puede ser nulo
    private Integer yearLaunchMovie;
}
