package com.tp_spring.palapi.domain;

public class Suitability {
    private String type;
    private int level;
    private String image;

    public Suitability() {
        
    }

    public Suitability(String _type, int _level, String _image) {
        this.type = _type;
        this.level = _level;
        this.image = _image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
