package com.thienbinh.myaudio.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.thienbinh.myaudio.R
import com.thienbinh.myaudio.databinding.ActivityMainBinding

class MainActivity : Activity() {
  private lateinit var mainBinding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ActivityMainBinding.inflate(layoutInflater)

    setContentView(mainBinding.root)
  }
}