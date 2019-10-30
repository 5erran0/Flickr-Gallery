package com.ginzo.flirckrgallery.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ginzo.flirckrgallery.R
import entities.Photo

class PhotoListAdapter() : RecyclerView.Adapter<PhotoViewHolder>() {
  var photos: List<Photo> = emptyList()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
    return PhotoViewHolder(view)
  }

  override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
    holder.bind(photos[position])
  }

  override fun getItemCount(): Int {
    return photos.size
  }
}