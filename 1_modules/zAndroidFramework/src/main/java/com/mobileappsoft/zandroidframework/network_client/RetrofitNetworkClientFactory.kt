package com.mobileappsoft.zandroidframework.network_client

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkClientFactory {

    fun getNetworkClient(baseUrl: String, serializationFactory: Converter.Factory =
            GsonConverterFactory.create())
            : Retrofit {

        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(serializationFactory)
            .client(okHttpClient)
            .build()
    }

}