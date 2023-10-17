package com.example.dtochallenge.controller;

import com.example.dtochallenge.domain.dto.PokemonDto;
import com.example.dtochallenge.repository.PokemonRepository;
import com.example.dtochallenge.repository.TrainerRepository;
import com.example.dtochallenge.service.PokemonMapper;
import com.example.dtochallenge.service.PokemonService;
import com.example.dtochallenge.service.TrainerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;
    private final PokemonMapper pokemonMapper;
    private final PokemonService pokemonService;
    private final TrainerMapper trainerMapper;


    public PokemonController(PokemonRepository pokemonRepository, TrainerRepository trainerRepository, PokemonMapper pokemonMapper, PokemonService pokemonService, TrainerMapper trainerMapper) {
        this.pokemonRepository = pokemonRepository;
        this.trainerRepository = trainerRepository;
        this.pokemonMapper = pokemonMapper;
        this.pokemonService = pokemonService;
        this.trainerMapper = trainerMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<PokemonDto> pokemonsDtos = pokemonService.getAll();
            return ResponseEntity.status(200).body(pokemonsDtos);
        } catch(Exception e) {
            return ResponseEntity.status(404).body("An error occured");

        }
    }

    @GetMapping("/{name}")
    public PokemonDto getByName(@PathVariable @NotNull String name) {
           return pokemonService.getByName(name);

    };


}
