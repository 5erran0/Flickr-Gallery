package com.ginzo.flirckrgallery

import com.ginzo.flirckrgallery.main.di.MainFactory
import com.ginzo.flirckrgallery.main.di.MainFactoryImpl
import di.DataFactory
import di.DataFactoryImpl
import di.DomainFactory
import di.DomainFactoryImpl

class DependencyInjectorManager {

  private val dataFactory: DataFactory by lazy {
    DataFactoryImpl()
  }

  private val domainFactory: DomainFactory by lazy {
    DomainFactoryImpl(dataFactory.provideFlickrRepository())
  }

  val mainFactory: MainFactory by lazy {
    MainFactoryImpl(domainFactory.provideSearchPhotosUseCase())
  }

}