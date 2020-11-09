package com.thienbinh.myaudio.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StoryFullInformation(
  var id: Int,
  var author: String,
  val name: String,
  @SerializedName("category_name")
  val categoryName: String,
  @SerializedName("chapter_new")
  val chapterNew: ChapterSortInformation? = null,
  @SerializedName("china_name")
  val chinaName: String,
  @SerializedName("avg_rate")
  val avgRate: Float = 0f,
  @SerializedName("count_chapter")
  val countChapter: Int,
  @SerializedName("count_comment")
  val countComment: Int = 0,
  @SerializedName("count_like")
  val countLike: Int = 0,
  @SerializedName("count_nominated")
  val countNominated: Int = 0,
  @SerializedName("count_rate")
  val countRate: Int = 0,
  @SerializedName("image")
  val image: String,
  val introduce: String,
  @SerializedName("time_create")
  val time: String? = null
): Serializable

fun StoryFullInformation.isTheSameContent(other: StoryFullInformation) =
  this.id == other.id && this.name == other.name

data class StoryFullInformationResponse(
  val data: StoryFullInformation,
  val message: String,
  val type: String
)