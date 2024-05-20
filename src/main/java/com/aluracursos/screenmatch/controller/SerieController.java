package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@RequestMapping("/series")
@RestController
public class SerieController {

    @Autowired
    private SerieService servicio;

    @GetMapping()
    public List<SerieDTO> obtenerTodasLasSeries(){
        return servicio.obtenerTodasLasSeries();
    }
    @GetMapping("/top5")
    public List<SerieDTO> obtenerTop5(){
        return servicio.obtenerTop5();
    }
    @GetMapping("/lanzamientos")
    public List<SerieDTO> obtenerLanzamientosMasRecientes(){
        return servicio.obtenerLanzamientosMasRecientes();
    }
    @GetMapping("/{id}")
    public SerieDTO obtenerPorId(@PathVariable Long id){
        return servicio.obtenerPorId(id);
    }
    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO>obtenerTodasLasTemporadas(@PathVariable Long id) {
        return servicio.obtenerTodasLasTemporadas(id);
    }
    @GetMapping("/{id}/temporadas/{numeroDeTemporada}")
        public List<EpisodioDTO>obtenerTemporadasPorNumero(@PathVariable Long id,
                                                            @PathVariable Long numeroDeTemporada) {
            return servicio.obtenerTemporadasPorNumero(id,numeroDeTemporada);
    }
    @GetMapping("/categoria/{nombreGenero}")
    public List<SerieDTO> obtenerSeriePorCategoria(@PathVariable String nombreGenero){
        return servicio.obtenerTemporadasPorCategoria(nombreGenero);
    }
    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDTO>obtenerTop5Episodios(@PathVariable Long id) {
        return servicio.obtenerTop5Episodios(id);
    }

}
