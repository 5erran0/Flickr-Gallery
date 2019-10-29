package di

import repositories.FlickrRepository

interface DataFactory {
  fun provideFlickrRepository(): FlickrRepository
}