package api

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import entities.PhotoPageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

class FlickrApiRest {
  internal suspend fun getImagesBySearch(search: String, page: Int): PhotoPageEntity =
    withContext(Dispatchers.IO) {
      val url = Uri.Builder()

      url.scheme("https")
        .authority("www.flickr.com")
        .path("/services/rest/")
        .appendQueryParameter("api_key", "3e7cc266ae2b0e0d78e279ce8e361736")
        .appendQueryParameter("format", "json")
        .appendQueryParameter("nojsoncallback", "1").appendQueryParameter("safe_search", "1")
        .appendQueryParameter("method", "flickr.photos.search")
        .appendQueryParameter("text", search)
        .appendQueryParameter("page", "$page")

      val json = JSONObject(URL(url.toString()).readText())
      PhotoPageEntity.parseFromJson(json.getJSONObject("photos"))
    }

  internal suspend fun getImageFromUrl(url: String): Bitmap = withContext(Dispatchers.IO) {
    val inputStream = URL(url).openStream()
    val bitmap = BitmapFactory.decodeStream(inputStream)
    bitmap
  }
}