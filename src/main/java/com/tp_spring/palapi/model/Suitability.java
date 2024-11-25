package com.tp_spring.palapi.model;

public class Suitability {
    private String type;
    private int level;

    public Suitability(String type, int level) {
        this.type = type;
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
