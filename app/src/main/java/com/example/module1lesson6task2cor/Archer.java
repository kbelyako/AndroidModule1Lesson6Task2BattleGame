package com.example.module1lesson6task2cor;

public class Archer extends BattleUnit {
    public Archer() {
        this.category = "Archer";
        this.initialHealth = 10;
        this.attackWeight = 3;
        this.defenceLevel = 2;
        this.alive = true;
        health = initialHealth + defenceLevel;
    }
}
