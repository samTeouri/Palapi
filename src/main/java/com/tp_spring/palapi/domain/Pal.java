package com.tp_spring.palapi.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pals")
public class Pal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cle;
    private String name;
    private String wiki;
    private int rarity;
    private double price;
    private String size;
    private List<String> types = new ArrayList<>();
    private List<String> drops = new ArrayList<>();
    
    @Embedded
    @ElementCollection
    private List<Suitability> suitability = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    @Embedded
    private Stats stats;

    // Constructor
    public Pal(
        String _cle,
        String _name,
        String _wiki,
        int _rarity,
        double _price,
        String _size,
        List<String> _types,
        List<String> _drops,
        List<Suitability> _suitability,
        List<Skill> _skills,
        Stats _stats
        ) {
            this.cle = _cle;
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

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public String getKey() {
        return this.cle;
    }

    public void setKey(String cle) {
        this.cle = cle;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWiki() {
        return this.wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Suitability> getSuitability() {
        return this.suitability;
    }

    public void setSuitability(List<Suitability> suitability) {
        this.suitability = suitability;
    }

    public List<String> getDrops() {
        return this.drops;
    }

    public void setDrops(List<String> drops) {
        this.drops = drops;
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public int getRarity() {
        return this.rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
