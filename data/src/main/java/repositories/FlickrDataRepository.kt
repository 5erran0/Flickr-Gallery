package repositories

import entities.PhotoPage

class FlickrDataRepository constructor(
  private val apiRepository: FlickrApiRepository
) : FlickrRepository {

  override suspend fun search(text: String): PhotoPage {
    return apiRepository.search(text)
  }
}