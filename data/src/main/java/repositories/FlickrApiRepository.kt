package repositories

import api.FlickrApiRest

class FlickrApiRepository constructor(
    private val restApi: FlickrApiRest
) {

  internal suspend fun search(text: String): String {
    return restApi.getImagesBySearch(text)
  }
}