package com.ginzo.flirckrgallery.main

import entities.Photo

interface MainView {
  fun render(state: MainViewState)
}

sealed class MainViewState {
  object Error : MainViewState()
  object Loading : MainViewState()
  object EmptySearch : MainViewState()
  data class ShowingFlickrImages(val photos: List<Photo>) : MainViewState()
}