package di

import repositories.FlickrRepository
import usecases.GetImageFromUrlUseCase
import usecases.SearchPhotosUseCase

class DomainFactoryImpl constructor(
  private val repository: FlickrRepository
) : DomainFactory {
  override fun provideSearchPhotosUseCase(): SearchPhotosUseCase {
    return SearchPhotosUseCase(repository)
  }

  override fun provideGetImageFromUrlUseCase(): GetImageFromUrlUseCase {
    return GetImageFromUrlUseCase(repository)
  }
}