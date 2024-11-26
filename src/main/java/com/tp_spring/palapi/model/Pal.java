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

@Entity
@Table(name="pals")
public class Pal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String key;
    private String name;
    private String wiki;
    private String rarity;
    private double price;
    private String size;
    private List<String> types = new ArrayList<>();
    private List<String> drops = new ArrayList<>();
    
    @ElementCollection
    private List<Suitability> suitability = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    @Embedded
    private Stats stats;

    // Constructor
    public Pal(
        String _key,
        String _name,
        String _wiki,
        String _rarity,
        double _price,
        String _size,
        List<String> _types,
        List<String> _drops,
        List<Suitability> _suitability,
        List<Skill> _skills,
        Stats _stats
        ) {
            this.key = _key;
            this.name = _name;
            this.wiki = _wiki;
            this.rarity = _rarity;
            this.price = _price;
            this.size = _size;
            this.types = _types;
            this.drops = _drops;
            this.suitability = _suitability;
            this.skills = _skills;
            this.stats = _stats;
    }



}
