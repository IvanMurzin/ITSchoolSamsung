package ru.ivanmurzin.sharedpreferences;

public class Cat {
    long tail;
    int paws;
    String name;
    boolean dead;

    public Cat(long tail, int paws, String name, boolean deadOrAlive) {
        this.tail = tail;
        this.paws = paws;
        this.name = name;
        this.dead = deadOrAlive;
    }

    @Override
    public String toString() {
        return tail + ";" + paws + ";" + name + ";" + dead;
    }

    public static Cat getFromString(String string) {
        String[] fields = string.split(";");
        if (fields.length != 4) return null;
        try {
            long tail = Long.parseLong(fields[0]);
            int paws = Integer.parseInt(fields[1]);
            String name = fields[2];
            boolean deadOrAlive = Boolean.parseBoolean(fields[3]);
            return new Cat(tail, paws, name, deadOrAlive);
        } catch (Exception e) {
            return null;
        }
    }
}
