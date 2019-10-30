package di

import usecases.GetImageFromUrlUseCase
import usecases.SearchPhotosUseCase

interface DomainFactory {
  fun provideSearchPhotosUseCase(): SearchPhotosUseCase
  fun provideGetImageFromUrlUseCase(): GetImageFromUrlUseCase
}