package com.thienbinh.myaudio.store.action

import com.thienbinh.myaudio.model.HomeApiModel
import org.rekotlin.Action

sealed class HomeAction: Action {
  class FETCH_HOME_DATA_ACTION : Action
  class UPDATE_IS_FETCHING(var isFetching: Boolean): Action
  class UPDATE_HOME_DATA_ACTION(var data: HomeApiModel): Action
}