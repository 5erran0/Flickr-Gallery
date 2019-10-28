package com.ginzo.flirckrgallery

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainPresenter constructor(
  private val view: MainView
) : DefaultLifecycleObserver {

  private lateinit var mainScope: CoroutineScope

  override fun onCreate(owner: LifecycleOwner) {
    mainScope = CoroutineScope(Job() + Main)

    mainScope.launch {
      getFlickrImages()
    }
  }

  override fun onDestroy(owner: LifecycleOwner) {
    mainScope.coroutineContext.cancel()
  }

  private suspend fun getFlickrImages() {
    thread("getFlickrImages()")
    val text = get("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsoncallback=1&safe_search=1&text=kittens")
    view.render(MainViewState.ShowingFlickrImages(text))
  }

  suspend fun get(url: String): String = withContext(Dispatchers.IO) {
    thread("get()")
    URL(url).readText()
  }

  private fun thread(functionName: String) {
    Log.e("App", "$functionName : ${Thread.currentThread().name}")
  }
}