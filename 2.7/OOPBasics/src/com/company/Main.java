package com.company;

import java.lang.invoke.StringConcatException;

interface Attackable {
    int attack();
    int defence();
}


interface A extends Attackable{
    int a();
}

abstract class Unit {
    final String name;
    public int health;

    public Unit(String name, int health) {
        System.out.println("Создаю Unit");
        this.name = name;
        this.health = health;
    }

    final void printInfo() {
        System.out.println("name " + name);
        System.out.println("health " + health);
    }
    abstract int attack();
}

final class Wizard extends Unit implements A{

    Wizard(String name, int health, int mana) {
        super(name, health - 10);
        System.out.println("Создаю Wizard");
        this.mana = mana;
    }

    private int mana;

    @Override
    public int attack() {
        return 10;
    }

    @Override
    public int defence() {
        return -9;
    }



    @Override
    public int a() {
    }
}

class Robot extends Unit implements Attackable {
    private int armor;

    public Robot(String name, int health, int armor) {
        super(name, health);
        this.armor = armor;
    }

    @Override
    public int attack() {
        return 110;
    }

    @Override
    public int defence() {
        return -1000;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
