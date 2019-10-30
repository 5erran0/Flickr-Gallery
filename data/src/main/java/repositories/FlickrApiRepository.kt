package repositories

import android.graphics.Bitmap
import api.FlickrApiRest
import entities.PhotoPage

class FlickrApiRepository constructor(
  private val restApi: FlickrApiRest
) {

  internal suspend fun search(text: String, page: Int): PhotoPage {
    return restApi.getImagesBySearch(text, page).toDomain()
  }

  internal suspend fun getImageFromUrl(url: String): Bitmap {
    return restApi.getImageFromUrl(url)
  }
}