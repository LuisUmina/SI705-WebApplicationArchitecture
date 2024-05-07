package pe.edu.upc.democlase.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.democlase.Dtos.ReviewByMovieDTO;
import pe.edu.upc.democlase.Dtos.ReviewDTO;
import pe.edu.upc.democlase.Dtos.pointsByMovieDTO;
import pe.edu.upc.democlase.Entities.Review;
import pe.edu.upc.democlase.ServiceInterfaces.IReviewServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private IReviewServiceInterface reviewServiceInterface;

    @PostMapping("/Insertar")
    public void insertar(@RequestBody ReviewDTO reviewDTO){
        ModelMapper m = new ModelMapper();
        Review r = m.map(reviewDTO, Review.class);
        reviewServiceInterface.insert(r);
    }

    @GetMapping("/listar")
    public List<ReviewDTO> listar(){
        return reviewServiceInterface.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ReviewDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/CantidadCriticasPorPelicula")
    public List<ReviewByMovieDTO> cantidadCriticasPorPelicula(){
        List<String[]> filaLista = reviewServiceInterface.quantityReviewByMovie();
        List<ReviewByMovieDTO> dtoLista = new ArrayList<>();

        for(String[] columna : filaLista){
            ReviewByMovieDTO dto = new ReviewByMovieDTO();
            dto.setNameMovie(columna[0]);
            dto.setQuantityReview(Integer.parseInt(columna[1])); // Convertir de String a Integer
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/sumaPuntosPorPelicula")
    public List<pointsByMovieDTO> sumaPuntosPorPelicula(){
        List<String[]> filaLista = reviewServiceInterface.sumPointsReviewByMovie();
        List<pointsByMovieDTO> dtoLista = new ArrayList<>();

        for(String[] columna : filaLista){
            pointsByMovieDTO dto = new pointsByMovieDTO();
            dto.setNameMovie(columna[0]);
            dto.setTotalPointsMovie(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
