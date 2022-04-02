package ru.ivanmurzin.rickandmorty.controller;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.ivanmurzin.rickandmorty.model.CharacterDataAll;

public interface CharacterController {
    @GET("character")
    Call<CharacterDataAll> getAllCharacters();
}
