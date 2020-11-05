package com.thienbinh.myaudio.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChapterSortInformation(
  val id: Long,
  @SerializedName("content_title_of_chapter")
  val chapterTitle: String,
  @SerializedName("name_id_chapter")
  val nameIdChapter: String,
  val url: String,
  @SerializedName("time_create")
  val time: String
): Serializable
