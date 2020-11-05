package com.thienbinh.myaudio.model

import java.io.Serializable

data class ChapterSorterInformation(
  val chapterId: String? = null,
  val type: String,
  val href: String? = null,
  val title: String
): Serializable

data class ChapterSorterInformationResponse(
  val data: List<ChapterSorterInformation>,
  val message: String,
  val type: String
): Serializable
