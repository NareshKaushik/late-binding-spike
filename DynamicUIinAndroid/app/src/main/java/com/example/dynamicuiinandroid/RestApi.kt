package com.example.latebindingspike

import com.example.dynamicuiinandroid.customviews.model.Response
import com.google.gson.JsonObject
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://my-json-server.typicode.com/"


val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface RestApi {
    @GET("NareshKaushik/late-binding/db")
    suspend fun getLayoutDetails(): Response
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object BechtelApi {
    val retrofitService: RestApi by lazy { retrofit.create(RestApi::class.java) }
}