package com.tp_spring.palapi.domain;

public class Skill {
    private int level;
    private String name;
    private String type;
    private int cooldown;
    private int power;
    private String description;

    public Skill(int level, String name, String type, int cooldown, int power, String description) {
        this.level = level;
        this.name = name;
        this.type = type;
        this.cooldown = cooldown;
        this.power = power;
        this.description = description;
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
