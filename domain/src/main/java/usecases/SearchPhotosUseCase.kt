package usecases

import repositories.FlickrRepository

class SearchPhotosUseCase constructor(
    private val repository: FlickrRepository
) {
  suspend fun search(text: String): String {
    return repository.search(text)
  }
}