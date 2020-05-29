package com.example.news.api;

import com.example.news.Models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //in this interface we declare tittle of the news link, it helps to see the news
    //if we remove this news will be disappear

    @GET("top-headlines")
    Call<News> getNews(

            @Query("country") String q ,
            @Query("apiKey") String apiKey);


//it helps to search news

    @GET("everything")
    Call<News> getNewsSearch(

            @Query("q") String keyword,
            @Query("language") String language,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey);

}