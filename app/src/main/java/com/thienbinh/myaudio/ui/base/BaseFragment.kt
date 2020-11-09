package com.thienbinh.myaudio.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.thienbinh.myaudio.ui.activity.MainActivity

class BaseFragment: Fragment() {
  private var mainActivity: MainActivity? = null

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    mainActivity = if (context is MainActivity){
      context as MainActivity
    }else null
  }

}