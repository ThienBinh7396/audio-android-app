package com.thienbinh.myaudio.store.reducer

import com.thienbinh.myaudio.store.state.RootState
import org.rekotlin.Action

fun rootReducer(action: Action, rootState: RootState?) =
  RootState(
    homeState = homeReducer(action, rootState?.homeState)
  )
