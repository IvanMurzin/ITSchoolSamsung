package ru.ivanmurzin.rickandmorty.controller;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ivanmurzin.rickandmorty.model.CharacterData;
import ru.ivanmurzin.rickandmorty.model.CharacterDataAll;

public class APIController {
    Retrofit retrofit = new Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public ArrayList<CharacterData> getAllCharacters() {
        CharacterController controller = retrofit.create(CharacterController.class);
        Call<CharacterDataAll> request = controller.getAllCharacters();
        try {
            Response<CharacterDataAll> response = request.execute();
            return response.body().results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
