package entities

import usecases.SearchPhotosUseCase

interface DomainFactory {
  fun provideSearchPhotosUseCase(): SearchPhotosUseCase
}