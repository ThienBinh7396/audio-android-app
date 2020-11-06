package com.thienbinh.myaudio.store.middleware

import com.thienbinh.myaudio.store.action.HomeAction
import com.thienbinh.myaudio.store.state.RootState
import org.rekotlin.DispatchFunction
import org.rekotlin.Middleware

internal val homeMiddleware: Middleware<RootState> = { dispatch, _ ->
  { next ->
    { action ->
      run {
        when(action){
          is HomeAction.FETCH_HOME_DATA_ACTION -> {
            fetchHomeData(dispatch)
          }
        }

        next(action)
      }
    }
  }
}

fun fetchHomeData(dispatch: DispatchFunction){

}
