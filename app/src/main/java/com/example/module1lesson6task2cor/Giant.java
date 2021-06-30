package com.example.module1lesson6task2cor;

public class Giant extends BattleUnit{
    public Giant() {
           this.category = "Giant";
           this.initialHealth = 10;
           this.attackWeight = 7;
           this.defenceLevel = 5;
           this.alive = true;
           health = initialHealth + defenceLevel;
    }
}
