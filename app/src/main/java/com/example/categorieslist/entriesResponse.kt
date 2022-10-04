package com.example.categorieslist

import com.google.gson.annotations.SerializedName

data class entriesResponse(
    val count:Int,
    val entries:List<Entrie>
)

data class Entrie (
    @SerializedName("API") var API:String,
    @SerializedName("Description") var Description:String,
    @SerializedName("Auth") var Auth:String,
    @SerializedName("HTTPS") var HTTPS:Boolean,
    @SerializedName("Cors") var Cors:String,
    @SerializedName("Link") var Link:String,
    @SerializedName("Category") var Category:String,
        )
