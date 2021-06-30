package com.example.module1lesson6task2cor;

public class Corvet extends SwimableBattleUnit{

    public Corvet() {
        this.category="Corvet";
            this.initialHealth = 70;
            this.attackWeight = 25;
            this.defenceLevel = 15;
            this.alive = true;
            health = initialHealth + defenceLevel;

    }
}
