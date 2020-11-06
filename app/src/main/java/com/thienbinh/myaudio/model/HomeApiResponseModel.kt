package com.thienbinh.myaudio.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HomeApiModel(
  @SerializedName("story_finish")
  val storyFinish: List<StoryFullInformation>,
  @SerializedName("story_hot_months")
  val storyHotMonths: List<StoryFullInformation>,
  @SerializedName("story_news")
  val storyNews: List<StoryFullInformation>,
  @SerializedName("story_nominateds")
  val storyNominated: List<StoryFullInformation>,
  @SerializedName("story_starts")
  val storyStarts: List<StoryFullInformation>
): Serializable

data class HomeApiModelResponse(
  val type: String,
  val message: String,
  val data: HomeApiModel
): Serializable
