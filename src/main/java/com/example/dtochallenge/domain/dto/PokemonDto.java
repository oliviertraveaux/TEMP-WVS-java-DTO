package com.example.dtochallenge.domain.dto;

import com.example.dtochallenge.domain.enumeration.PokemonAttribut;

public class PokemonDto {

    private PokemonAttribut attribut;
    private String name;

    private Long trainerId;

    public PokemonAttribut getAttribut() {
        return attribut;
    }

    public void setAttribut(PokemonAttribut attribut) {
        this.attribut = attribut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
}
