/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment10_inheritance;

/**
 *
 * @author priya
 */
class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}
class Warrior extends Fighter {

    @Override
    boolean isVulnerable() {
        return false; 
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if (fighter.isVulnerable()) {
            return 10; 
        } else {
            return 6;  
        }
    }

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }
}
class Wizard extends Fighter {
    private boolean spellPrepared = false;

    void prepareSpell() {
        spellPrepared = true; 
    }

    @Override
    boolean isVulnerable() {
        return !spellPrepared; 
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if (spellPrepared) {
            return 12; 
        } else {
            return 3; 
        }
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }
}


public class WarriorAndWizard {
     public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        System.out.println(warrior.toString()); 
        System.out.println(warrior.isVulnerable()); 

        System.out.println(warrior.getDamagePoints(wizard)); 
        
        System.out.println(wizard.toString()); 
        System.out.println(wizard.isVulnerable()); 

        wizard.prepareSpell();
        System.out.println(wizard.isVulnerable()); 
        System.out.println(wizard.getDamagePoints(warrior)); 
    }
}
