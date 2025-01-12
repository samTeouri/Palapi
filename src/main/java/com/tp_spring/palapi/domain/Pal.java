package com.tp_spring.palapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pals")
public class Pal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String cle;

    @Column(insertable=true, updatable=true)
    private String name;
    
    private String wiki;
    private int rarity;
    private double price;
    private String size;
    private String image;
    private String imageWiki;

    @Column(insertable=false, updatable=false)
    private String description;
    
    private String asset;
    private String genus;

    @ElementCollection
    @CollectionTable(name = "pal_types", joinColumns = @JoinColumn(name = "pal_id"))
    private List<String> types = new ArrayList<>();
    private List<String> drops = new ArrayList<>();
    
    @Embedded
    @ElementCollection
    private List<Suitability> suitability = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    @Embedded
    private Stats stats;

    @Embedded
    private Aura aura;

    @Embedded
    private Maps maps;

    // Constructor
    public Pal() {

    }

    public Pal(
        String _cle,
        String _name,
        String _wiki,
        int _rarity,
        double _price,
        String _size,
        String _image,
        String _imageWiki,
        String _description,
        String _asset,
        String _genus,
        List<String> _types,
        List<String> _drops,
        List<Suitability> _suitability,
        List<Skill> _skills,
        Stats _stats,
        Aura _aura,
        Maps _maps
        ) {
            this.cle = _cle;
            this.name = _name;
            this.wiki = _wiki;
            this.rarity = _rarity;
            this.price = _price;
            this.size = _size;
            this.image = _image;
            this.image = _imageWiki;
            this.description = _description;
            this.asset = _asset;
            this.genus = _genus;
            this.types = _types;
            this.drops = _drops;
            this.suitability = _suitability;
            this.skills = _skills;
            this.stats = _stats;
            this.aura = _aura;
            this.maps = _maps;
    }

    // Getters and Setters
    public int getId() {
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

    public Aura getAura() {
        return this.aura;
    }

    public void setAura(Aura aura) {
        this.aura = aura;
    }

    public Maps getMaps() {
        return this.maps;
    }

    public void setMaps(Maps maps) {
        this.maps = maps;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageWiki() {
        return this.imageWiki;
    }

    public void setImageWiki(String imageWiki) {
        this.imageWiki = imageWiki;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAsset() {
        return this.asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getGenus() {
        return this.genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}
