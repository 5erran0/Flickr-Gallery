package com.ginzo.flirckrgallery.main.di

import com.ginzo.flirckrgallery.main.MainActivity
import com.ginzo.flirckrgallery.main.MainPresenter
import usecases.SearchPhotosUseCase

class MainFactoryImpl constructor(
  private val searchPhotosUseCase: SearchPhotosUseCase
) : MainFactory {
  override fun provideMainPresenter(activity: MainActivity): MainPresenter {
    return MainPresenter(activity, searchPhotosUseCase)
  }
}