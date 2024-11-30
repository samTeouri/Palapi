package com.tp_spring.palapi.application.dto;

import java.util.List;

public class PalDTO {
    private Long id;
    private String name;
    private List<String> types;
    private int rarity;
    private Double price;
    private String size;

    // Constructeur sans arguments
    public PalDTO() {
    }

    // Constructeur avec tous les arguments
    public PalDTO(Long id, String name, List<String> types, int rarity, Double price, String size) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.rarity = rarity;
        this.price = price;
        this.size = size;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
