package ru.ivanmurzin.dolgiproject.data;

public class Debt {
    public String name;
    public float money;

    public Debt(String name, float money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}