package com.thienbinh.myaudio.store.reducer

import com.thienbinh.myaudio.store.action.HomeAction
import com.thienbinh.myaudio.store.state.HomeState
import org.rekotlin.Action

fun homeReducer(action: Action, _homeState: HomeState?): HomeState {
  var homeState = _homeState ?: HomeState()

  when (action) {
    is HomeAction.UPDATE_HOME_DATA_ACTION -> {
      val data = action.data

      homeState = homeState.copy(
        storyFinish = data.storyFinish,
        storyHotMonths = data.storyHotMonths,
        storyNews = data.storyNews,
        storyNominated = data.storyNominated,
        storyStarts = data.storyStarts
      )
    }
  }

  return homeState
}