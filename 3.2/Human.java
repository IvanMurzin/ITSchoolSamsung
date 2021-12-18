package ru.ivanmurzin.classesandwheretheylive;

import android.util.Log;

public class Human {
    int height;
    boolean humanity;
    short hands;
    long legs;
    int sanity;

    Head head;
    Body body;

    void saySomething() {
        class Speech {
            static final int a = 1;
            String thought = "о пельменях";
            String name = "Вася";
            String howToSay = "голодным голосом";

            @Override
            public String toString() {
                return "Человек по имени " + name + " сказал " + howToSay + " " + thought;
            }
        }
        Log.wtf("Human", "I'm machine. I never sleep");
        Log.wtf("Human", (new Speech()).toString());
    }

    class Head {
        int eyes = hands;
        long hair;
        String mouth;

        void eyeWink() {
            legs = 1;
            sanity += 1;
            saySomething();

            height += 2;
            Log.wtf("Human", "Я моргаю!");
        }
    }

    static class Body {

        static int y;
        static final double pi = 3.14;

        //int width = height;
        int sides = height;
        long back;

        void breakBack() {
            Log.w("Human", "Опять спина болит!");
        }
    }
}

//chat -256 256 2^9 бит

