package com.thienbinh.myaudio.store.state

import com.google.gson.annotations.SerializedName
import com.thienbinh.myaudio.model.StoryFullInformation
import org.rekotlin.StateType

data class RootState(
  var homeState: HomeState
): StateType