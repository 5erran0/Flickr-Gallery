package repositories

class FlickrDataRepository constructor(
    private val apiRepository: FlickrApiRepository
) : FlickrRepository {

  override suspend fun search(text: String): String {
    return apiRepository.search(text)
  }
}