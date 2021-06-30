package com.example.module1lesson6task2cor;

public class SwordsMan extends BattleUnit{
    public SwordsMan() {
            this.category="SwordsMan";
            this.initialHealth = 10;
            this.attackWeight = 4;
            this.defenceLevel = 4;
            this.alive = true;
            health = initialHealth + defenceLevel;
}

}
