package com.example.ibdaatest.api;


import android.graphics.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {
    @GET("volley_array.json")
    Call<List<Movie>> getMovies();
}