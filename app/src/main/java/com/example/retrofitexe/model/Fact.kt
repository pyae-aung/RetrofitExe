package com.example.retrofitexe.model

import retrofit2.http.Body

data class Fact(
    var id: String,
    var title: String,
    var textBody: String
)