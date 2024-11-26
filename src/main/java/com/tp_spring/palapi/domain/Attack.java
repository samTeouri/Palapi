package com.tp_spring.palapi.domain;

import jakarta.persistence.Embeddable;


public class Attack {
    private int melee;
    private int ranged;

    public Attack(int melee, int ranged) {
        this.melee = melee;
        this.ranged = ranged;
    }

    public int getMelee() {
        return melee;
    }

    public void setMelee(int melee) {
        this.melee = melee;
    }
    public int getRanged() {
        return ranged;
    }
    public void setRanged(int ranged) {
    this.ranged = ranged;
    }


}

