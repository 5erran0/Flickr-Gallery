package com.ginzo.flirckrgallery.main.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ginzo.flirckrgallery.R
import entities.Photo

class PhotoViewHolder(
  private val view: View
) : RecyclerView.ViewHolder(view) {

  fun bind(photo: Photo) {
    val imageView = view.findViewById<ImageView>(R.id.imageView)
  }
}