package com.example.universe.planetary_body.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universe.planetary_body.model.PlanetaryBodyModel;
import com.example.universe.planetary_body.service.PlanetaryBodyService;

@RequestMapping("/api/planetary-body")
@RestController
public class PlanetaryBodyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlanetaryBodyController.class);

    @Autowired
    private PlanetaryBodyService planetaryBodyService;

    @GetMapping
    public ResponseEntity<List<PlanetaryBodyModel>> findAllPlanetaryBody() {
        return new ResponseEntity<>(planetaryBodyService.findAllPlanetaryBody(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetaryBodyModel> findPlanetaryBodyById(@PathVariable Long id) {
        Optional<PlanetaryBodyModel> data = planetaryBodyService.findPlanetaryBodyById(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PlanetaryBodyModel> savePlanetaryBody(@RequestBody PlanetaryBodyModel planetaryBodyModel) {
        LOGGER.info("Name : " + planetaryBodyModel.getName());
        LOGGER.info("Mass : " + planetaryBodyModel.getMass());
        try {
            return new ResponseEntity<>(planetaryBodyService.savePlanetaryBody(planetaryBodyModel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanetaryBodyModel> updatePlanetaryBodyModel(@PathVariable("id") long id,
            @RequestBody PlanetaryBodyModel planetaryBody) {
        Optional<PlanetaryBodyModel> planetaryBodyData = planetaryBodyService.findPlanetaryBodyById(id);
        if (planetaryBodyData.isPresent()) {
            PlanetaryBodyModel _planetaryBody = planetaryBodyData.get();
            _planetaryBody.setName(planetaryBody.getName());
            _planetaryBody.setMass(planetaryBody.getMass());
            _planetaryBody.setRadius(planetaryBody.getRadius());
            _planetaryBody.setNumberOfMoons(planetaryBody.getNumberOfMoons());
            return new ResponseEntity<>(planetaryBodyService.savePlanetaryBody(planetaryBody), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlanetaryBodyModel(@PathVariable("id") long id) {
        try {
            planetaryBodyService.deletePlanetaryBodyById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllPlanetaryBodyModels() {
        try {
            planetaryBodyService.deleteAllPlanetaryBodies();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
