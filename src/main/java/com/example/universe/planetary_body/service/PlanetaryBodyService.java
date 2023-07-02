package com.example.universe.planetary_body.service;

import java.util.List;
import java.util.Optional;

import com.example.universe.planetary_body.model.PlanetaryBodyModel;

public interface PlanetaryBodyService {

    public List<PlanetaryBodyModel> findAllPlanetaryBody();

    public PlanetaryBodyModel savePlanetaryBody(PlanetaryBodyModel planetaryBodyModel);

    public Optional<PlanetaryBodyModel> findPlanetaryBodyById(Long id);

    public void deletePlanetaryBodyById(Long id);

    public void deleteAllPlanetaryBodies();

}