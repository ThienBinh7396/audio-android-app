package com.thienbinh.myaudio.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.thienbinh.myaudio.R

class MainActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
      DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
  }
}