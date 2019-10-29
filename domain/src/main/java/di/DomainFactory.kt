package di

import usecases.SearchPhotosUseCase

interface DomainFactory {
  fun provideSearchPhotosUseCase(): SearchPhotosUseCase
}