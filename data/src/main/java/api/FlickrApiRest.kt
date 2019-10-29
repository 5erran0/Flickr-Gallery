package api

import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class FlickrApiRest {
  internal suspend fun getImagesBySearch(search: String): String = withContext(Dispatchers.IO) {
    val url = Uri.Builder()

    url.scheme("https")
      .authority("www.flickr.com")
      .path("/services/rest/")
      .appendQueryParameter("api_key", "3e7cc266ae2b0e0d78e279ce8e361736")
      .appendQueryParameter("format", "json")
      .appendQueryParameter("nojsoncallback", "1").appendQueryParameter("safe_search", "1")

    if (search.isNotEmpty()) {
      url.appendQueryParameter("method", "flickr.photos.search")
        .appendQueryParameter("text", search)
    } else {
      url.appendQueryParameter("method", "flickr.photos.getRecent")
    }

    URL(url.toString()).readText()
  }
}