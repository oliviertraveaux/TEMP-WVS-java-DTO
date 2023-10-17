package com.example.dtochallenge.service;

import com.example.dtochallenge.domain.dto.PokemonDto;
import com.example.dtochallenge.domain.entity.Pokemon;
import com.example.dtochallenge.domain.entity.Trainer;
import com.example.dtochallenge.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PokemonMapper {

    private TrainerRepository trainerRepository;

    public PokemonMapper(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public PokemonDto TransformPokemonEntityToPokemonDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setAttribut(pokemon.getAttribut());

        if (Objects.nonNull(pokemon.getTrainer()) && Objects.nonNull(pokemon.getTrainer().getId())) {
            pokemonDto.setTrainerId(pokemon.getTrainer().getId());
        }

        return pokemonDto;
    }

    public Pokemon TransformPokemonDtoToPokemonEntity(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setAttribut(pokemonDto.getAttribut());

        if(Objects.nonNull(pokemonDto.getTrainerId())) {
            Optional<Trainer> oTrainer = trainerRepository.findById(pokemonDto.getTrainerId());
            if (oTrainer.isPresent()) {
                Trainer trainer = oTrainer.get();
                pokemon.setTrainer(trainer);
            }
//            Equivalent :
//            trainerRepository.findById(pokemonDto.getTrainerId()).ifPresent(pokemon::setTrainer);
        }
        return pokemon;
    }
}
