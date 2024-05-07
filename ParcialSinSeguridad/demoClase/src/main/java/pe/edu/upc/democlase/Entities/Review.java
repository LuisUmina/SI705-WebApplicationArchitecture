package pe.edu.upc.democlase.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Review")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;

    @Column(name = "pointsReview", nullable = false)
    private int pointsReview;

    @Column(name = "descriptionReview", nullable = false, length = 200)
    private String descriptionReview;

    @Column(name = "datePublicationReview", nullable = false)
    private LocalDate datePublicationReview;

    @Column(name = "sourceReview", nullable = false, length = 40)
    private String sourceReview;


    @ManyToOne //-> Para que sepa que es una relación de muchos a uno
    @JoinColumn(name = "idMovie") //-> Para que sepa que es una llave foránea
    private Movie movie;

}
