package com.tp_spring.palapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="pals")
public class Pal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    
    private String name;

    private String wiki;

    @ElementCollection
    private List<String> types = new ArrayList<>();

    @ElementCollection
    private List<String> suitability = new ArrayList<>();

    @ElementCollection
    private List<String> drops = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    @Embedded
    private Stats stats;

    private String rarity;

    private double price;

    private String size;
}
