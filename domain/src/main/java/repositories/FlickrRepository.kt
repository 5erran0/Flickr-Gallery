package repositories

import android.graphics.Bitmap
import entities.PhotoPage

interface FlickrRepository {
  suspend fun search(text: String, page: Int): PhotoPage
  suspend fun getImageFromUrl(url: String): Bitmap
}