package com.example.module1lesson6task2cor;


/*
ДЗ. Задание 2. Вам не выжить :)
1. За основу взять игру с фермером, башней и воином.
2. Ввести параметр Health. Он есть у всех, т.е. нужно создать родитель Unit с параметром
здоровья.
3. Ввести водные юниты: Рыбацкая лодка, Корвет, Фрегат и Линкор. Продумать разную силу
атаки.
4. Ввести наземные юниты: копейщик, легкий мечник, тяжелы мечник, конник, генерал.
5. В MainActivity создать несколько армий (ArrayList) из воинов.
6. Сделать метод Battle, где сталкивать армии. Подумайте, как считать исход битвы.
 */

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<BattleUnit> armyAL1 = new  ArrayList<BattleUnit>();
        ArrayList<BattleUnit> armyAL2 = new  ArrayList<BattleUnit>();
        for (int i=1;i<=20;i++){
            armyAL1.add(new Archer());
            armyAL2.add(new Archer());

            armyAL1.add(new Knight());
            armyAL1.add(new SwordsMan());
            armyAL1.add(new Giant());
            armyAL1.add(new Archer());
            armyAL1.add(new SwordsMan());
            armyAL1.add(new SwordsMan());
            armyAL1.add(new SwordsMan());
            armyAL1.add(new SwordsMan());

            armyAL2.add(new Knight());
            armyAL2.add(new SwordsMan());
            armyAL2.add(new Giant());
            armyAL2.add(new Giant());
            armyAL2.add(new Giant());
            armyAL2.add(new Archer());
            armyAL2.add(new Archer());

        }

        Army army1= new Army ("Vikings",armyAL1);
        Army army2= new Army ("Skiffs",armyAL2);

        ArrayList<BattleUnit> navyAL1 = new  ArrayList<BattleUnit>();
        ArrayList<BattleUnit> navyAL2 = new  ArrayList<BattleUnit>();

        Navy navy1= new Navy("GreatNavy",navyAL1);
        Navy navy2= new Navy("EasternNavy",navyAL2);

        for (int i=1;i<=5;i++){
            navyAL1.add(new Boat());
            navyAL1.add(new Boat());
            navyAL1.add(new Boat());
            navyAL1.add(new Corvet());
            navyAL1.add(new Linkor());

            navyAL2.add(new Boat());
            navyAL2.add(new Corvet());
            navyAL2.add(new Linkor());
            navyAL2.add(new Corvet());
        }

        Log.d("MyLOG", groupOfBattleUnitsFight(navy1,navy2));
        Log.d("MyLOG", groupOfBattleUnitsFight(army1,army2));

    }



    public void unitsFight (BattleUnit unit1, BattleUnit unit2){

        double unit1DeathLevel=unit1.health/10;
        double unit2DeathLevel=unit1.health/10;
        Random rn = new Random();
        int randomDesicion=rn.nextInt(9 - 0 + 1) + 0;

        while (unit1.health>unit1DeathLevel && unit2.health>unit1DeathLevel){

            if (randomDesicion <5) {
                unit2.attack(unit1);
                if(unit1.health>unit1DeathLevel && unit2.health>unit2DeathLevel)
                    unit1.attack(unit2);
            }
            else{
                unit1.attack(unit2);
                if(unit1.health>unit1DeathLevel && unit2.health>unit2DeathLevel)
                    unit2.attack(unit1);
            }

        }
        if (unit1.health<=unit1DeathLevel) {
            unit1.disable();
        }
        if (unit2.health<=unit2DeathLevel) unit2.disable();
        //String result=unit1.category+" after fight health="+unit1.health +unit2.category+" after fight health="+unit2.health;

       // return result;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    //public String armyFight (ArrayList <BattleUnit> army1, ArrayList <BattleUnit> army2){
    public String groupOfBattleUnitsFight (GroupOfBattleUnits groupOfBattleUnits1, GroupOfBattleUnits groupOfBattleUnits2){
        String gobuStateAfterFight ="";
        String gobuStateBeforeFight=groupOfBattleUnits1.getFullInfo()+"\n"
                +groupOfBattleUnits2.getFullInfo();
        String gobuStateBeforeAndAfterFight ="";
        Log.d("MyLOG", " before fight ");
        Log.d("MyLOG", groupOfBattleUnits1.getFullInfo());
        Log.d("MyLOG", groupOfBattleUnits2.getFullInfo());
        //Log.d("MyLOG", groupOfBattleUnits1.name+" totalBattleUnitsNum="+groupOfBattleUnits1.numberOfBattleUnits()+" Totalhealth="+groupOfBattleUnits1.calcTotalHealthLevel()+", totalAttackpower="+groupOfBattleUnits1.calcTotalAttackPowerLevel()) ;
        //Log.d("MyLOG", groupOfBattleUnits2.name+" totalBattleUnitsNum="+groupOfBattleUnits2.numberOfBattleUnits()+" Totalhealth="+groupOfBattleUnits2.calcTotalHealthLevel()+", totalAttackpower="+groupOfBattleUnits2.calcTotalAttackPowerLevel()) ;
        // groupOfBattleUnits1.printBattleUnits();
        // groupOfBattleUnits2.printBattleUnits();

        String result="";
        if(groupOfBattleUnits1.numberOfBattleUnits()!=0 && groupOfBattleUnits2.numberOfBattleUnits()!=0){
            while (groupOfBattleUnits1.numberOfBattleUnits()!=0 && groupOfBattleUnits2.numberOfBattleUnits()!=0) {


                try{
                    unitsFight(groupOfBattleUnits1.getBattleUnit(0),groupOfBattleUnits2.getBattleUnit(0));
                }catch (Exception e) {

                    Log.d("MyLOG", "exception has been thrown " + e.toString());
                }
                if (groupOfBattleUnits1.getBattleUnit(0).alive == false) {
                    //    Log.d("MyLOG", "groupOfBattleUnits1.getBattleUnit(0) health= " + groupOfBattleUnits1.getBattleUnit(0).health+"groupOfBattleUnits2.getBattleUnit(0) health= " + groupOfBattleUnits2.getBattleUnit(0).health);
                    Log.d("MyLOG", groupOfBattleUnits1.getBattleUnit(0).category + " from "+groupOfBattleUnits1.name+" has been destroyed by " + groupOfBattleUnits2.getBattleUnit(0).category+" from "+groupOfBattleUnits2.name);
                    groupOfBattleUnits1.content.remove(0);
                    Log.d("MyLOG", groupOfBattleUnits1.name+" " + groupOfBattleUnits1.numberOfBattleUnits() + " BattleUnits left");
                }

                if (groupOfBattleUnits2.getBattleUnit(0).alive == false) {
                    Log.d("MyLOG", groupOfBattleUnits2.getBattleUnit(0).category + " from "+groupOfBattleUnits2.name+" has been destroyed by " + groupOfBattleUnits1.getBattleUnit(0).category+" from "+groupOfBattleUnits1.name);
                    groupOfBattleUnits2.content.remove(0);
                    Log.d("MyLOG", groupOfBattleUnits2.name+" " + groupOfBattleUnits2.numberOfBattleUnits() + " BattleUnits left");
                }


            }
            gobuStateAfterFight=groupOfBattleUnits1.getFullInfo()+"\n"
                    +groupOfBattleUnits2.getFullInfo();
            gobuStateBeforeAndAfterFight="Before fight state:"+"\n"+gobuStateBeforeFight+"\n"+
                    "After fight state:"+"\n"+gobuStateAfterFight;
            if(groupOfBattleUnits1.content.isEmpty()) {
                result ="\n"+  groupOfBattleUnits2.name+" has won the battle "+ groupOfBattleUnits2.name+" "+ groupOfBattleUnits2.numberOfBattleUnits() + " BattleUnits left, "+groupOfBattleUnits1.name+" " + groupOfBattleUnits1.numberOfBattleUnits() + " BattleUnits left"
                        //+"\n"+groupOfBattleUnits2.name+" Totalhealth="+groupOfBattleUnits2.calcTotalHealthLevel()+", totalBattleUnitsNum="+groupOfBattleUnits2.numberOfBattleUnits()+", totalAttackpower="+groupOfBattleUnits2.calcTotalAttackPowerLevel()
                       // +"\n"+groupOfBattleUnits1.name+" Totalhealth="+groupOfBattleUnits1.calcTotalHealthLevel()+", totalBattleUnitsNum="+groupOfBattleUnits1.numberOfBattleUnits()+", totalAttackpower="+groupOfBattleUnits1.calcTotalAttackPowerLevel();
                        +"\n"+gobuStateBeforeAndAfterFight;
            }
            if(groupOfBattleUnits2.content.isEmpty()) {
                result ="\n"+ groupOfBattleUnits1.name+" has won the battle "+ groupOfBattleUnits1.name+" "+ groupOfBattleUnits1.numberOfBattleUnits()
                        + " BattleUnits left, "+groupOfBattleUnits2.name+" " + groupOfBattleUnits2.numberOfBattleUnits() + " BattleUnits left"
                       //+"\n"+groupOfBattleUnits1.name+" Totalhealth="+groupOfBattleUnits1.calcTotalHealthLevel()+", totalBattleUnitsNum="+groupOfBattleUnits1.numberOfBattleUnits()+", totalAttackpower="+groupOfBattleUnits1.calcTotalAttackPowerLevel()
                      //+"\n"+groupOfBattleUnits2.name+" Totalhealth="+groupOfBattleUnits2.calcTotalHealthLevel()+", totalBattleUnitsNum="+groupOfBattleUnits2.numberOfBattleUnits()+", totalAttackpower="+groupOfBattleUnits2.calcTotalAttackPowerLevel();
                        +"\n"+gobuStateBeforeAndAfterFight;
            }

            //   Log.d("MyLOG", " after fight ");

            //   Log.d("MyLOG", groupOfBattleUnits1.name+" totalBattleUnitsNum="+groupOfBattleUnits1.numberOfBattleUnits()+" Totalhealth="+groupOfBattleUnits1.calcTotalHealthLevel()+", totalAttackpower="+groupOfBattleUnits1.calcTotalAttackPowerLevel()) ;
            //   Log.d("MyLOG", groupOfBattleUnits2.name+" totalBattleUnitsNum="+groupOfBattleUnits2.numberOfBattleUnits()+" Totalhealth="+groupOfBattleUnits2.calcTotalHealthLevel()+", totalAttackpower="+groupOfBattleUnits2.calcTotalAttackPowerLevel()) ;
            //   groupOfBattleUnits1.printBattleUnits();
            //   groupOfBattleUnits2.printBattleUnits();


        }
        else
            result="Battle not possible one or both GroupOfBattleUnitses is eampty";

        return result;
    }


}