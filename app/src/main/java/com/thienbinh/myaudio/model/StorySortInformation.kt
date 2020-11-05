package com.thienbinh.myaudio.model.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StorySortInformation(
  var id: Int,
  var name: String,
  @SerializedName("story_type")
  var storyType: Int,
  var type: String,
  var url: String
): Serializable

data class StorySortInformationResponse(
  val type: String,
  val message: String,
  val data: List<StorySortInformation>
): Serializable
