package usecases

import android.graphics.Bitmap
import repositories.FlickrRepository

class GetImageFromUrlUseCase constructor(
  private val repository: FlickrRepository
) {
  suspend fun getImageFromUrl(url: String): Bitmap {
    return repository.getImageFromUrl(url)
  }
}