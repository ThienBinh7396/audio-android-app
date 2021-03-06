package com.thienbinh.myaudio.util

enum class DelayTime(val value: Long) {
  DELAY_DEFAULT(500L),
  DELAY_1MS(1L),
  DELAY_10MS(10L),
  DELAY_100MS(100L),
  DELAY_150MS(150L),
  DELAY_200MS(200L),
  DELAY_300MS(300L),
  DELAY_400MS(400L),
  DELAY_600MS(600L),
  DELAY_700MS(700L),
  DELAY_800MS(800L),
  DELAY_1000MS(1000L),
  DELAY_1500MS(1500L),
  DELAY_2000MS(2000L),
  DELAY_3000MS(3000L),
  DELAY_4000MS(4000L),
  DELAY_5000MS(5000L),
}

enum class TAG(val value: String) {
  API("FETCH_RESULT")
}

enum class ApiRepresent(val value: String) {
  HOME_API("HOME_API")
}
