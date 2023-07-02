package com.example.universe.planetary_body.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planetary_body")
public class PlanetaryBodyModel implements Serializable {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    @NotNull(message="Name cannot be null")
    private String name;
    @Positive 
    private Float mass;
    @Positive 
    private Float radius;
    @Positive 
    private Integer numberOfMoons;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getMass() {
        return mass;
    }
    public void setMass(Float mass) {
        this.mass = mass;
    }
    public Float getRadius() {
        return radius;
    }
    public void setRadius(Float radius) {
        this.radius = radius;
    }
    public Integer getNumberOfMoons() {
        return numberOfMoons;
    }
    public void setNumberOfMoons(Integer numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }
}
