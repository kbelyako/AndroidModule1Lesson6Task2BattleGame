package com.example.module1lesson6task2cor;

public class Boat  extends SwimableBattleUnit{
    public Boat() {
        this.category="Boat";
        this.initialHealth = 50;
        this.attackWeight = 10;
        this.defenceLevel = 10;
        this.alive = true;
        health = initialHealth + defenceLevel;
    }


}
