package com.example.module1lesson6task2cor;

public class Linkor extends BattleUnit {
    public Linkor() {
        this.category="Linkor";
        this.initialHealth = 110;
        this.attackWeight = 40;
        this.defenceLevel = 25;
        this.alive = true;
        health = initialHealth + defenceLevel;
    }
}
