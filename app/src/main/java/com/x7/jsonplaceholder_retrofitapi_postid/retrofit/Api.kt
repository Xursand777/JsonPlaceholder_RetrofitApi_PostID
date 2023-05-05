package com.x7.jsonplaceholder_retrofitapi_postid.retrofit

import com.x7.jsonplaceholder_retrofitapi_postid.model.JsonPostIdModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {

    @GET("/posts/{son}/comments")
    fun getCountry(@Path("son") PostId:Int):Call<ArrayList<JsonPostIdModelItem>>

    @GET("comments")
    fun getCountry2(@Query("posts") PostdId:Int):Call<ArrayList<JsonPostIdModelItem>>

}