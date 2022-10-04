package com.example.categorieslist

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ServiceAPI {
    @GET
 suspend fun getResponse(@Url url:String):Response<entriesResponse>
}