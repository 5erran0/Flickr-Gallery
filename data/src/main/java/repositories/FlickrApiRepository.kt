package repositories

import api.FlickrApiRest
import entities.PhotoPage

class FlickrApiRepository constructor(
  private val restApi: FlickrApiRest
) {

  internal suspend fun search(text: String): PhotoPage {
    return restApi.getImagesBySearch(text).toDomain()
  }
}