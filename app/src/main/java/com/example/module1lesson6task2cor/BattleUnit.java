package com.example.module1lesson6task2cor;

public class BattleUnit implements Attacking {
    String category;
    //String;
    int initialHealth;
    int attackWeight;
    int defenceLevel;
    int health;
    boolean alive;


    public BattleUnit() {
         //   this.category = category;
        //if (category=="Giant") {
         //   this.initialHealth = 10;
        //    this.attackWeight = 7;
       //     this.defenceLevel = 5;
       //     this.alive = true;
           // health = initialHealth + defenceLevel;
        }
/*
        if (category=="Archer") {
            this.initialHealth = 10;
            this.attackWeight = 3;
            this.defenceLevel = 2;
            this.alive = true;
            health = initialHealth + defenceLevel;
        }
        if (category=="SwordsMan") {
            this.initialHealth = 10;
            this.attackWeight = 4;
            this.defenceLevel = 4;
            this.alive = true;
            health = initialHealth + defenceLevel;
        }
        if (category=="Knight") {
            this.initialHealth = 10;
            this.attackWeight = 6;
            this.defenceLevel = 5;
            this.alive = true;
            health = initialHealth + defenceLevel;
        }

        //Рыбацкая лодка, Корвет, Фрегат и Линкор

        if (category=="Boat") {
            this.initialHealth = 50;
            this.attackWeight = 10;
            this.defenceLevel = 10;
            this.alive = true;
            health = initialHealth + defenceLevel;
        }

        if (category=="Corvet") {
            this.initialHealth = 70;
            this.attackWeight = 25;
            this.defenceLevel = 15;
            this.alive = true;
            health = initialHealth + defenceLevel;
        }

        if (category=="Fregat") {
            this.initialHealth = 90;
            this.attackWeight = 35;
            this.defenceLevel = 20;
            this.alive = true;
            health = initialHealth + defenceLevel;
        }

        if (category=="Linkor") {
            this.initialHealth = 110;
            this.attackWeight = 40;
            this.defenceLevel = 25;
            this.alive = true;
            health = initialHealth + defenceLevel;
        }

    }

 */

    public void attack(BattleUnit attacked){
        attacked.health = attacked.health - this.attackWeight;
    }

    public void disable(){
        this.alive=false;
        this.health = 0;
        this.attackWeight=0;
        this.defenceLevel=0;
    }

}
