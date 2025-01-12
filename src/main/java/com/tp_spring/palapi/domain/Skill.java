package com.tp_spring.palapi.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int level;
    private String name;
    private String type;
    private int cooldown;
    private int power;
    private String description;

    public Skill() {
        
    }
    
    public Skill(int level, String name, String type, int cooldown, int power, String description) {
        this.level = level;
        this.name = name;
        this.type = type;
        this.cooldown = cooldown;
        this.power = power;
        this.description = description;
    }
    
    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
