package com.example.dtochallenge.service;

import com.example.dtochallenge.domain.dto.TrainerDto;
import com.example.dtochallenge.domain.entity.Trainer;
import com.example.dtochallenge.repository.TrainerRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;
    private TrainerMapper trainerMapper;


    public TrainerService(TrainerRepository trainerRepository, TrainerMapper trainerMapper) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
    }

    public List<TrainerDto> getAll() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream().map(trainerMapper::TransformTrainerEntityToTrainerDto).toList();
    }


    public TrainerDto getById(Long id) {
        Optional<Trainer> oTrainer = trainerRepository.findById(id);

        if (oTrainer.isPresent()) {
            return trainerMapper.TransformTrainerEntityToTrainerDto(oTrainer.get());
        } else {
            throw new EntityNotFoundException();
        }
    }

    public TrainerDto create(TrainerDto trainerDto) {
        if (Objects.nonNull(trainerDto.getId())) {
            throw new EntityExistsException();
        } else {
            return trainerMapper.TransformTrainerEntityToTrainerDto(trainerRepository.save(trainerMapper.TransformTrainerDtoToTrainerEntity(trainerDto)));
        }
    }

}
