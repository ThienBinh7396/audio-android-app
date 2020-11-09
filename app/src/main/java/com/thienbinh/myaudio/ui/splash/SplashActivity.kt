package com.thienbinh.myaudio.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.thienbinh.myaudio.R
import com.thienbinh.myaudio.databinding.ActivitySplashBinding
import com.thienbinh.myaudio.ui.activity.MainActivity
import com.thienbinh.myaudio.util.DelayTime
import java.util.*

class SplashActivity : AppCompatActivity() {
  companion object{
    const val TIMER_TAG = "TIMER_TAG"
  }

  private lateinit var viewBinding: ActivitySplashBinding
  private lateinit var timer: Timer
  private lateinit var timerTask: TimerTask

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewBinding =
      ActivitySplashBinding.inflate(layoutInflater).apply {
        splashViewModel = SplashViewModel()
        lifecycleOwner = this@SplashActivity

        setupSlide()

        gotoMainActivity()
      }

    setContentView(viewBinding.root)
  }

  private fun gotoMainActivity() {
    Handler(Looper.getMainLooper()).postDelayed({
      val intentToMainActivity = Intent(this@SplashActivity, MainActivity::class.java)
      startActivity(intentToMainActivity)
    }, 5000)
  }

  private fun setupSlide() {
    timer = Timer(TIMER_TAG)
    timerTask = object : TimerTask() {
      override fun run() {
        viewBinding.viewPager.apply {
          if (adapter != null) {
            val nextPosition =
              (adapter as SplashSlideAdapter).getNextPosition()
            smoothScrollToPosition(nextPosition)

            Log.d("Binh", "Position: $nextPosition")
          }
        }
      }
    }

    timer.schedule(timerTask, 0, DelayTime.DELAY_4000MS.value)
  }

  override fun onDestroy() {
    super.onDestroy()

    timer.cancel()
  }
}