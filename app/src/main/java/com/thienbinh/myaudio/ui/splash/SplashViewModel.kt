package com.thienbinh.myaudio.ui.splash

import androidx.lifecycle.ViewModel
import com.thienbinh.myaudio.R

class SplashViewModel : ViewModel() {
  private val _images = mutableListOf<Int>()
  val images
    get() = _images.toList()


  init {
    _images.addAll(
      listOf(
        R.drawable.splash_1,
        R.drawable.splash_5,
        R.drawable.splash_3,
        R.drawable.splash_4,
        R.drawable.splash_6,
        R.drawable.splash_7
      )
    )
  }
}