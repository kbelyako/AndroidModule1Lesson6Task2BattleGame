package com.example.module1lesson6task2cor;


import android.util.Log;

import java.util.ArrayList;

public class GroupOfBattleUnits {
    String name;
    ArrayList<BattleUnit> content;
    Integer totalinitialHealthLevel=0;
    Integer totalinitialAttackPower=0;


    public GroupOfBattleUnits(String name, ArrayList<BattleUnit> content) {
        this.name = name;
        this.content = content;

        totalinitialHealthLevel=calcTotalHealthLevel();
        totalinitialAttackPower=calcTotalAttackPowerLevel();
    }
    public int  calcTotalHealthLevel() {
        int totalHealthLevel=0;
        if (content.isEmpty()!=true) {
            for (BattleUnit battleUnit : content) {
                totalHealthLevel = totalHealthLevel + battleUnit.health;
            }
        }
        return totalHealthLevel;

    }

    public int calcTotalAttackPowerLevel(){
        int totalAttackPower=0;
        if (content.isEmpty()!=true) {
            for (BattleUnit battleUnit : content) {
                totalAttackPower = totalAttackPower + battleUnit.attackWeight;
            }
        }
        return totalAttackPower;
    }

    public int  numberOfBattleUnits(){
        int result=0;
        result=this.content.size();
        return result;
    }

    public BattleUnit  getBattleUnit(int index){
        BattleUnit result=null;
        if (content.isEmpty()!=true) {
            result = this.content.get(index);
        }
        return result;
    }

    public void printBattleUnits() {
        String BattleUnitsHealthLevel="";
        if (content.isEmpty()!=true) {

            for (BattleUnit battleUnit : content) {
                if (BattleUnitsHealthLevel.length()==0) {
                    BattleUnitsHealthLevel=BattleUnitsHealthLevel+battleUnit.health;}
                else BattleUnitsHealthLevel=BattleUnitsHealthLevel+";"+battleUnit.health;
            }
        }
        Log.d("MyLOG", this.name+" content="+BattleUnitsHealthLevel);

    }

    public String getFullInfo() {
        return this.name+" totalBattleUnitsNum="+this.numberOfBattleUnits()+" Totalhealth="+this.calcTotalHealthLevel()+", totalAttackpower="+this.calcTotalAttackPowerLevel();

    }
}
