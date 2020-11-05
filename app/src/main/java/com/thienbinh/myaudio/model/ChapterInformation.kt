package com.thienbinh.myaudio.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChapterInformation (
  val chapter: String,
  val content: String,
  val id: Long,
  @SerializedName("title_story")
  val titleStory: String,
  @SerializedName("url_story")
  val urlStory: String
): Serializable

data class ChapterInformationResponse(
  val data: ChapterInformation,
  val message: String,
  val type: String
): Serializable
