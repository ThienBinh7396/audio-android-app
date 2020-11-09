package com.thienbinh.myaudio.store.middleware

import android.util.Log
import com.thienbinh.myaudio.model.HomeApiModelResponse
import com.thienbinh.myaudio.model.api.APIUtils
import com.thienbinh.myaudio.store.action.HomeAction
import com.thienbinh.myaudio.store.state.RootState
import com.thienbinh.myaudio.util.ApiRepresent
import com.thienbinh.myaudio.util.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.rekotlin.DispatchFunction
import org.rekotlin.Middleware
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal val homeMiddleware: Middleware<RootState> = { dispatch, _ ->
  { next ->
    { action ->
      run {
        when (action) {
          is HomeAction.FETCH_HOME_DATA_ACTION -> {
            fetchHomeData(dispatch)
          }
        }

        next(action)
      }
    }
  }
}

fun fetchHomeData(dispatch: DispatchFunction) = CoroutineScope(Main).launch {
  dispatch(HomeAction.UPDATE_IS_FETCHING(true))
  val task = async(Dispatchers.IO) {
    var resultData: HomeApiModelResponse? = null
    APIUtils.getApiService().fetchHomeInformation()
      .enqueue(object : Callback<HomeApiModelResponse> {
        override fun onResponse(
          call: Call<HomeApiModelResponse>,
          response: Response<HomeApiModelResponse>
        ) {
          resultData = response.body()
        }

        override fun onFailure(call: Call<HomeApiModelResponse>, t: Throwable) {
          Log.d(TAG.API.value, "${ApiRepresent.HOME_API.value}: ${t.message}")
        }
      })
    return@async resultData
  }

  val result = task.await()

  if (result != null){
    dispatch(HomeAction.UPDATE_HOME_DATA_ACTION(result.data))
  }else{
    dispatch(HomeAction.UPDATE_IS_FETCHING(false))
  }
}