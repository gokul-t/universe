package com.example.universe.planetary_body.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universe.planetary_body.model.PlanetaryBodyModel;
import com.example.universe.planetary_body.repository.PlanetaryBodyRepository;
import com.example.universe.planetary_body.service.PlanetaryBodyService;

@Service
public class PlanetaryBodyServiceImpl implements PlanetaryBodyService {
    @Autowired
    PlanetaryBodyRepository planetaryBodyRepository;

    @Override
    public List<PlanetaryBodyModel> findAllPlanetaryBody() {
        return planetaryBodyRepository.findAll();
    }

    @Override
    public PlanetaryBodyModel savePlanetaryBody(PlanetaryBodyModel planetaryBodyModel) {
        return planetaryBodyRepository.save(planetaryBodyModel);
    }

    @Override
    public Optional<PlanetaryBodyModel> findPlanetaryBodyById(Long id) {
        return planetaryBodyRepository.findById(id);
    }

    @Override
    public void deletePlanetaryBodyById(Long id) {
        planetaryBodyRepository.deleteById(id);
        return;
    }

    @Override
    public void deleteAllPlanetaryBodies() {
        planetaryBodyRepository.deleteAll();
        return;
    }
}
