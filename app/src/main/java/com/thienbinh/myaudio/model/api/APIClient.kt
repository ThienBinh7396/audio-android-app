package com.thienbinh.myaudio.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
  companion object {
    private var mapRetrofitByURL = mutableMapOf<String, Retrofit>()

    fun getClient(baseURL: String): Retrofit{
      if (mapRetrofitByURL[baseURL] == null){
        mapRetrofitByURL[baseURL] = Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
      }

      return mapRetrofitByURL[baseURL]!!
    }
  }
}