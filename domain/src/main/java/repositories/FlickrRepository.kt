package repositories

import android.graphics.Bitmap
import entities.PhotoPage

interface FlickrRepository {
  suspend fun search(text: String): PhotoPage
  suspend fun getImageFromUrl(url: String): Bitmap
}