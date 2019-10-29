package repositories

import entities.PhotoPage

interface FlickrRepository {
  suspend fun search(text: String): PhotoPage
}