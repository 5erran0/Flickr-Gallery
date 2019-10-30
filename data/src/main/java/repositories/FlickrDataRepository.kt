package repositories

import android.graphics.Bitmap
import entities.PhotoPage

class FlickrDataRepository constructor(
  private val apiRepository: FlickrApiRepository
) : FlickrRepository {

  override suspend fun search(text: String): PhotoPage {
    return apiRepository.search(text)
  }

  override suspend fun getImageFromUrl(url: String): Bitmap {
    return apiRepository.getImageFromUrl(url)
  }
}