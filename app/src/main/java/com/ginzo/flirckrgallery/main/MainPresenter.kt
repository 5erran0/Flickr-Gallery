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
    view.render(MainViewState.Loading)

    mainScope = CoroutineScope(Job() + Main)

    mainScope.launch {
      getFlickrImages()
    }
  }

  override fun onDestroy(owner: LifecycleOwner) {
    mainScope.coroutineContext.cancel()
  }

  fun search(search: String) {
    view.render(MainViewState.Loading)

    mainScope.launch {
      getFlickrImages(search)
    }
  }

  private suspend fun getFlickrImages(search: String = "") {
    if (search.isNotEmpty()) {
      val photoPage = searchPhotosUseCase.search(search)
      view.render(MainViewState.ShowingFlickrImages(photoPage.photos))
    } else {
      view.render(MainViewState.EmptySearch)
    }
  }
}