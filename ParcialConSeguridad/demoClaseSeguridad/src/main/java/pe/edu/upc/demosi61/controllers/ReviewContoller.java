package pe.edu.upc.demosi61.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demosi61.dtos.ConsultaReviewByMovieDTO;
import pe.edu.upc.demosi61.dtos.PointsByMovieDTO;
import pe.edu.upc.demosi61.dtos.ReviewDTO;
import pe.edu.upc.demosi61.entities.Review;
import pe.edu.upc.demosi61.servicesinterfaces.IReviewService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/criticas")
public class ReviewContoller {
    @Autowired
    private IReviewService rS;

    @PostMapping
    public void insertar(@RequestBody ReviewDTO reviewDTO) {
        ModelMapper m = new ModelMapper();

        Review r = m.map(reviewDTO, Review.class);
        rS.insert(r);
    }

    @GetMapping
    public List<ReviewDTO> listar() {
        return rS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ReviewDTO.class);
        }).collect(Collectors.toList());

    }

    @GetMapping("/consulta01")
    public List<ConsultaReviewByMovieDTO> consulta01() {
        List<String[]> filaLista = rS.quantityReviewByMovie();
        List<ConsultaReviewByMovieDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            ConsultaReviewByMovieDTO dto = new ConsultaReviewByMovieDTO();
            dto.setTitleMovie(columna[0]);
            dto.setQuantityReview(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }

        return dtoLista;
    }

    @GetMapping("/consulta02")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PointsByMovieDTO> consulta02() {
        List<String[]> filaLista = rS.pointsByMovie();
        List<PointsByMovieDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            PointsByMovieDTO dto = new PointsByMovieDTO();
            dto.setTitleMovie(columna[0]);
            dto.setPointsMovie(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }

        return dtoLista;

    }
}
