package com.thienbinh.myaudio.model.api

import com.thienbinh.myaudio.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
  @GET("story/home")
  fun fetchHomeInformation(): Call<HomeApiModelResponse>

  @GET("story/search")
  fun findStoryByName(): Call<StorySortInformationResponse>

  @GET("story/info")
  fun fetchStoryInformationById(
    @Query("id_story") idStory: Int
  ): Call<StoryFullInformationResponse>

  @GET("story/chapter-with-paginate")
  fun fetchAllChaptersInStoryByStoryId(
    @Query("storyId") idStory: Int,
    @Query("page") page: Int
  ): Call<ChapterSorterInformationResponse>

  @GET("story/read-chapter-url")
  fun fetchChapterContentByChapterUrl(
    @Query("chapter_url") chapterUrl: String
  ): Call<ChapterInformationResponse>

}