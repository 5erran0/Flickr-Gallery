package com.ginzo.flirckrgallery.main.di

import com.ginzo.flirckrgallery.main.MainActivity
import com.ginzo.flirckrgallery.main.MainPresenter

interface MainFactory {
    fun provideMainPresenter(activity: MainActivity): MainPresenter
}