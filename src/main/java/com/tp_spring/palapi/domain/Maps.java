package com.tp_spring.palapi.domain;

public class Maps {

    private String jour;
    private String night;

    public Maps() {

    }

    public Maps(String _jour, String _night) {
        this.jour =_jour;
        this.night =_night;
    }

    public String getDay() {
        return jour;
    }

    public void setDay(String jour) {
        this.jour = jour;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

}
