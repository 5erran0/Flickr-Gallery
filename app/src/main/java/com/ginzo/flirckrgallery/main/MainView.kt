package com.ginzo.flirckrgallery.main

interface MainView {
  fun render(state: MainViewState)
}

sealed class MainViewState {
  object Error : MainViewState()
  object Loading : MainViewState()
  data class ShowingFlickrImages(val string: String) : MainViewState()
}