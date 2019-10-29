package com.ginzo.flirckrgallery

import android.app.Application
import com.ginzo.flirckrgallery.main.di.MainFactory
import com.ginzo.flirckrgallery.main.di.MainFactoryProvider

class FlickrGalleryApp : Application(), MainFactoryProvider {

    private lateinit var diManager: DependencyInjectorManager

    override fun onCreate() {
        super.onCreate()
        diManager = DependencyInjectorManager()
    }

    override val mainFactory: MainFactory
        get() = diManager.mainFactory
}