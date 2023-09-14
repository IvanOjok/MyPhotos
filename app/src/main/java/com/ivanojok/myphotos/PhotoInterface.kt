package com.ivanojok.myphotos

import retrofit2.http.GET

interface PhotoInterface {

    @GET("/photos")
    suspend fun getPhotos(): List<Photos>
}