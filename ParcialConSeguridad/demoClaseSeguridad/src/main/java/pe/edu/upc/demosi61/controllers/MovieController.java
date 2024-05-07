package pe.edu.upc.demosi61.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demosi61.dtos.MovieDTO;
import pe.edu.upc.demosi61.entities.Movie;
import pe.edu.upc.demosi61.servicesinterfaces.IMovieServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/peliculas")
public class MovieController {
    @Autowired
    private IMovieServiceInterface mS;

    @PostMapping("/registrar")
    public void registrar(@RequestBody MovieDTO dtoM) {
        ModelMapper d = new ModelMapper();
        Movie movie = d.map(dtoM, Movie.class);
        mS.insert(movie);
    }
    @PutMapping("/modificar")
    public void modificar(@RequestBody MovieDTO dto){
        ModelMapper m=new ModelMapper();
        Movie mo=m.map(dto,Movie.class);
        mS.insert(mo);
    }
    @GetMapping("/listar")
    public List<MovieDTO> list() {
        return mS.list().stream().map(y -> {
            ModelMapper c = new ModelMapper();
            return c.map(y, MovieDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/eliminarPorId/{id}")
    public void delete(@PathVariable("id") Integer id) {
        mS.delete(id);
    }

    @GetMapping("/listarPorId/{id}")
    public MovieDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        MovieDTO dto=m.map(mS.listarId(id),MovieDTO.class);
        return dto;
    }
    @GetMapping("/buscarPorAnioPublicacion")
    public List<MovieDTO> buscar(@RequestParam int year) {
        return mS.findByYearPublication(year).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,MovieDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscargenero")
    @PreAuthorize("hasAuthority('USER')")
    public List<MovieDTO> buscar(@RequestParam String gen) {
        return mS.buscarGenero(gen).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MovieDTO.class);
        }).collect(Collectors.toList());
    }

}
