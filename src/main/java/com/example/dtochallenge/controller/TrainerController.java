package com.example.dtochallenge.controller;

import com.example.dtochallenge.domain.dto.TrainerDto;
import com.example.dtochallenge.service.TrainerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<TrainerDto> getAll() {
        return trainerService.getAll();
    }

    @GetMapping("/{id}")
    public TrainerDto getById(@PathVariable @NotNull Long id) {
        return trainerService.getById(id);
    }

    @PostMapping
    public TrainerDto create(@RequestBody @Valid TrainerDto trainerDto) {
       return trainerService.create(trainerDto);
    }

}
