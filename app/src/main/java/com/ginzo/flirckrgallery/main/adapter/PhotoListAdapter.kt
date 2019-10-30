package com.ginzo.flirckrgallery.main.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ginzo.flirckrgallery.R
import entities.Photo

class PhotoListAdapter(
  private val getImageFromUrl: (String) -> Bitmap
) : RecyclerView.Adapter<PhotoViewHolder>() {
  private val photos: MutableList<Photo> = mutableListOf()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
    return PhotoViewHolder(view, getImageFromUrl)
  }

  override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
    holder.bind(photos[position])
  }

  override fun getItemCount(): Int {
    return photos.size
  }

  fun addPage(photosNewPage: List<Photo>) {
    photos.addAll(photosNewPage)
    notifyDataSetChanged()
  }
}