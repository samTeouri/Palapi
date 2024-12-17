package com.tp_spring.palapi.domain;

import jakarta.persistence.Column;

public class Aura {
    @Column(name="aura_name")
    private String name;
    private String description;
    private String tech;

    public Aura() {

    }

    public Aura(String _name, String _description, String _tech) {
        this.name = _name;
        this.description = _description;
        this.tech = _tech;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
