package com.thienbinh.myaudio.store.state

import com.thienbinh.myaudio.model.StoryFullInformation
import org.rekotlin.StateType

data class HomeState(
  var isFetching:Boolean = false,
  var storyFinish: List<StoryFullInformation>? = null,
  var storyHotMonths: List<StoryFullInformation>? = null,
  var storyNews: List<StoryFullInformation>? = null,
  var storyNominated: List<StoryFullInformation>? = null,
  var storyStarts: List<StoryFullInformation>? = null
): StateType
