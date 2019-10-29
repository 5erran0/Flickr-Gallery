package repositories

interface FlickrRepository {
  suspend fun search(text: String): String
}