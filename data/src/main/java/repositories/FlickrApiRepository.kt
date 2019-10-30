package repositories

import android.graphics.Bitmap
import api.FlickrApiRest
import entities.PhotoPage

class FlickrApiRepository constructor(
  private val restApi: FlickrApiRest
) {

  internal suspend fun search(text: String, page: Int): PhotoPage {
    val photoPageEntity = restApi.getImagesBySearch(text, page)
    return photoPageEntity.toDomain()
  }

  internal suspend fun getImageFromUrl(url: String): Bitmap {
    return restApi.getImageFromUrl(url)
  }
}