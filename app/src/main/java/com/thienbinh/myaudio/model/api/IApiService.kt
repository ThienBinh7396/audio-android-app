package com.thienbinh.myaudio.model.api

import com.thienbinh.myaudio.model.ChapterInformationResponse
import com.thienbinh.myaudio.model.ChapterSorterInformationResponse
import com.thienbinh.myaudio.model.HomeApiResponseModel
import com.thienbinh.myaudio.model.StoryFullInformationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
  @GET("story/home")
  fun fetchHomeInformation(): Call<HomeApiResponseModel>

  @GET("story/search")
  fun findStoryByName(): Call<StorySortInformationResponse>

  @GET("story/info")
  fun fetchStoryInformationById(
    @Query("id_story") idStory: Int
  ): Call<StoryFullInformationResponse>

  @GET("story/chapter")
  fun fetchAllChaptersInStoryByStoryId(
    @Query("storyId") idStory: Int
  ): Call<ChapterSorterInformationResponse>

  @GET("story/read-chapter-url")
  fun fetchChapterContentByChapterUrl(
    @Query("chapter_url") chapterUrl: String
  ): Call<ChapterInformationResponse>

}