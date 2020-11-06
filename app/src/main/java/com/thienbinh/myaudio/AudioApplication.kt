package com.thienbinh.myaudio

import android.app.Application
import com.thienbinh.myaudio.store.middleware.homeMiddleware
import com.thienbinh.myaudio.store.reducer.rootReducer
import org.rekotlin.Store

val store = Store(
  reducer = ::rootReducer,
  state = null,
  middleware = listOf(homeMiddleware)
)

class AudioApplication: Application()
