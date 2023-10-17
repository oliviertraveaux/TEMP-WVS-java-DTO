package com.example.dtochallenge.service;

import com.example.dtochallenge.domain.dto.TrainerDto;
import com.example.dtochallenge.domain.entity.Pokemon;
import com.example.dtochallenge.domain.entity.Trainer;
import com.example.dtochallenge.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TrainerMapper {

    private PokemonRepository pokemonRepository;

    public TrainerMapper(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public TrainerDto TransformTrainerEntityToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(trainer.getId());
        trainerDto.setName(trainer.getName());
        trainerDto.setAge(trainer.getLevel());
        trainerDto.setLevel(trainer.getLevel());
        trainerDto.setPokemonIds(
                trainer.getPokemons().stream()
                        .map(Pokemon::getId)
                        .collect(Collectors.toList())
        );
        return trainerDto;
    }

    public Trainer TransformTrainerDtoToTrainerEntity(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setId(trainerDto.getId());
        trainer.setName(trainerDto.getName());
        trainer.setAge(trainerDto.getAge());
        trainer.setLevel(trainerDto.getLevel());

        List<Pokemon> pokemons = trainerDto.getPokemonIds().stream()
                .map(pokemonRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        trainer.setPokemons(pokemons);

        return trainer;
    }

}
