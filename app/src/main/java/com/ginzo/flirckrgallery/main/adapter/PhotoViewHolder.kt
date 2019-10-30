package com.ginzo.flirckrgallery.main.adapter

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ginzo.flirckrgallery.R
import entities.Photo
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class PhotoViewHolder(
  private val view: View,
  private val getImageFromUrl: (String) -> Bitmap
) : RecyclerView.ViewHolder(view) {

  fun bind(photo: Photo) {
    val imageView = view.findViewById<ImageView>(R.id.imageView)


    val image = getImageFromUrl(photo.url)
    imageView.setImageBitmap(image)
  }
}