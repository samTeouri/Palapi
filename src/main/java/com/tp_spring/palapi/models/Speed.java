package com.tp_spring.palapi.models;

public class Speed {
    private int ride;
    private int run;
    private int walk;

    public Speed(int ride, int run, int walk) {
        this.ride = ride;
        this.run = run;
        this.walk = walk;
    }

    public int getRide() {
        return ride;
    }

    public void setRide(int ride) {
        this.ride = ride;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getWalk() {
        return walk;
    }

    public void setWalk(int walk) {
        this.walk = walk;
    }
}
