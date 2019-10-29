package com.ginzo.flirckrgallery.main

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import usecases.SearchPhotosUseCase

class MainPresenter constructor(
  private val view: MainView,
  private val searchPhotosUseCase: SearchPhotosUseCase
) : DefaultLifecycleObserver {

  private lateinit var mainScope: CoroutineScope

  override fun onCreate(owner: LifecycleOwner) {
    mainScope = CoroutineScope(Job() + Main)

    mainScope.launch {
      getFlickrImages()
    }
  }

  override fun onDestroy(owner: LifecycleOwner) {
    mainScope.coroutineContext.cancel()
  }

  private suspend fun getFlickrImages() {
    val text = searchPhotosUseCase.search("")
    view.render(MainViewState.ShowingFlickrImages(text))
  }
}