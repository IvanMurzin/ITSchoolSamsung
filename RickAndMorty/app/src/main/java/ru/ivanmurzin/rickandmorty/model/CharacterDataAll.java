package ru.ivanmurzin.rickandmorty.model;

import java.util.ArrayList;

public class CharacterDataAll {
    public Info info;
    public ArrayList<CharacterData> results;

    class Info {
        public int count;
        public int pages;
        public String next;
        public String prev;
    }
}
