package com.example.module1lesson6task2cor;

public class Knight extends BattleUnit {
    public Knight() {
        this.category = "Knight";
        this.initialHealth = 10;
        this.attackWeight = 6;
        this.defenceLevel = 5;
        this.alive = true;
        health = initialHealth + defenceLevel;
    }
}
