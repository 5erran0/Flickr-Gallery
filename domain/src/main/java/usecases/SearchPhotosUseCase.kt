package usecases

import entities.PhotoPage
import repositories.FlickrRepository

class SearchPhotosUseCase constructor(
  private val repository: FlickrRepository
) {
  suspend fun search(text: String): PhotoPage {
    return repository.search(text)
  }
}