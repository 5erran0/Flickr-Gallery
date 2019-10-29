package di

import api.FlickrApiRest
import repositories.FlickrApiRepository
import repositories.FlickrDataRepository
import repositories.FlickrRepository

class DataFactoryImpl : DataFactory {
  private fun provideFlickrApiRest(): FlickrApiRest = FlickrApiRest()

  private fun provideFlickrApiRepository(): FlickrApiRepository =
    FlickrApiRepository(provideFlickrApiRest())

  override fun provideFlickrRepository(): FlickrRepository {
    return FlickrDataRepository(provideFlickrApiRepository())
  }
}