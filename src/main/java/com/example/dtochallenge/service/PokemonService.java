package com.example.dtochallenge.service;

import com.example.dtochallenge.domain.dto.PokemonDto;
import com.example.dtochallenge.domain.entity.Pokemon;
import com.example.dtochallenge.repository.PokemonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private PokemonMapper pokemonMapper;
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonMapper pokemonMapper, PokemonRepository pokemonRepository) {
        this.pokemonMapper = pokemonMapper;
        this.pokemonRepository = pokemonRepository;

    }

    public List<PokemonDto> getAll() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        return pokemons.stream().map(pokemonMapper::TransformPokemonEntityToPokemonDto).toList();
    }

    public PokemonDto getByName(String name) {

        Optional<Pokemon> oPokemon = pokemonRepository.findByName(name);

        if(oPokemon.isPresent()) {
            return pokemonMapper.TransformPokemonEntityToPokemonDto(oPokemon.get());
        } else {
            throw new EntityNotFoundException();
        }
    }

}
