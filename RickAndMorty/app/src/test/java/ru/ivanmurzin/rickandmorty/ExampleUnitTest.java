package ru.ivanmurzin.rickandmorty;

import com.google.gson.Gson;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    String jsonDogData = "{\"tail\":123,\"paws\":-1,\"name\":\"Jaja\",\"ownersName\":[\"me\",\"you\"]}\n";

    @Test
    public void addition_isCorrect() {
        Gson gson = new Gson();
        Dog dog = gson.fromJson(jsonDogData, Dog.class);
        System.out.println("name: " + dog.name + "\ntail: " + dog.tail + "\npaws: " + dog.paws);

    }

    class Dog {
        long tail;
        short paws;
        String name;
        String[] ownersName;
    }
}