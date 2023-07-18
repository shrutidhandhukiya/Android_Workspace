package com.example.project.Interface

import com.example.project.Model.CategoryModel
import com.example.project.Model.CategoryProduct
import com.example.project.Model.HomeModel
import com.example.project.Model.LoginModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApInterface {

    @FormUrlEncoded
    @POST("SignUp.php")
    fun signup(
        @Field("firstname") firstname:String,
        @Field("lastname") lastname:String,
        @Field("gender") gender:String,
        @Field("email") email:String,
        @Field("phone") phone:String,
        @Field("password") password:String):Call<Void>

    @FormUrlEncoded
    @POST("Login.php")
    fun loginData(
        @Field("phone")phone :String,
        @Field ("pass")pass:String):Call<LoginModel>

    @GET("category.php")
    fun viewData(): Call<List<HomeModel>>

    @GET("category1.php")
    fun  plantsData(): Call<List<CategoryModel>>

    @GET("product.php")
    fun productData(image: String?): Call<List<CategoryProduct>>
}