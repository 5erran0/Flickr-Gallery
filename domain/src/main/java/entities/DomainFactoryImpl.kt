package entities

import repositories.FlickrRepository
import usecases.SearchPhotosUseCase

class DomainFactoryImpl constructor(
  private val repository: FlickrRepository
) : DomainFactory {
  override fun provideSearchPhotosUseCase(): SearchPhotosUseCase {
    return SearchPhotosUseCase(repository)
  }
}