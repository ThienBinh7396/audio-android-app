package com.thienbinh.myaudio.model.api

class APIUtils {
  companion object{
    private const val BASE_URL = "https://my-audio1.herokuapp.com//api/"

    fun getApiService() =
      APIClient.getClient(BASE_URL).create(IApiService::class.java)
  }
}