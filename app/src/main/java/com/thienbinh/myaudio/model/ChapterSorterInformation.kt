package com.thienbinh.myaudio.model

import java.io.Serializable

data class ChapterSorterInformation(
  val idStory: Int,
  val href: String,
  val title: String
): Serializable

data class ChapterSorterInformationResponse(
  val data: List<ChapterSorterInformation>,
  val message: String,
  val type: String
): Serializable
