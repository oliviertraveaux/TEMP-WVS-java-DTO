package com.example.dtochallenge.domain.dto;


import java.util.List;

public class TrainerDto {

    private Long id;
    private String name;
    private Integer age;
    private Integer level;
    private List<Long> pokemonIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Long> getPokemonIds() {
        return pokemonIds;
    }

    public void setPokemonIds(List<Long> pokemonIds) {
        this.pokemonIds = pokemonIds;
    }
}
