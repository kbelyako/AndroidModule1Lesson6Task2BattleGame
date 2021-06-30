package com.example.module1lesson6task2cor;

public class Fregat extends SwimableBattleUnit {
    public Fregat() {
        this.category="Fregat";
        this.initialHealth = 90;
        this.attackWeight = 35;
        this.defenceLevel = 20;
        this.alive = true;
        health = initialHealth + defenceLevel;
    }

}
