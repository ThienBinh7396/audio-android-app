package com.thienbinh.myaudio.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingUtil {
  companion object{
    @BindingAdapter("bind:srcImage")
    @JvmStatic
    fun bindImage(iv: ImageView, src: Any?){
      src?.apply {
        Glide.with(iv)
          .load(this)
          .into(iv)
      }
    }
  }
}