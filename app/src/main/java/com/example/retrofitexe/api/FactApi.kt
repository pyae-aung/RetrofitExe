package com.example.retrofitexe.api

import com.example.retrofitexe.model.Fact
import retrofit2.Call
import retrofit2.http.GET

interface FactApi {
    @GET("posts")
    fun getFact(): Call<List<Fact>>
}