package com.example.dtochallenge.domain.entity;

import com.example.dtochallenge.domain.enumeration.PokemonAttribut;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PokemonAttribut attribut;
    private String name;

    @Min(0)
    @Max(10)
    private int power;


    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
