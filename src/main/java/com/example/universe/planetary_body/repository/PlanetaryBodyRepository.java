package com.example.universe.planetary_body.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universe.planetary_body.model.PlanetaryBodyModel;

public interface PlanetaryBodyRepository extends JpaRepository<PlanetaryBodyModel, Long> {

}
