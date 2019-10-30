package com.ginzo.flirckrgallery.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.ginzo.flirckrgallery.R
import com.ginzo.flirckrgallery.main.adapter.PhotoListAdapter
import com.ginzo.flirckrgallery.main.di.MainFactoryProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

  private lateinit var presenter: MainPresenter

  private lateinit var photoListAdapter: PhotoListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    presenter = (application as MainFactoryProvider).mainFactory
      .provideMainPresenter(this)

    photoListAdapter = photosList.adapter as? PhotoListAdapter ?: PhotoListAdapter()

    photosList.apply {
      layoutManager = GridLayoutManager(context, 3)
      adapter = photoListAdapter
    }

    retry.setOnClickListener {
      presenter.search(searchInput.text.toString())
    }

    btnSearch.setOnClickListener {
      presenter.search(searchInput.text.toString())
    }

    lifecycle.addObserver(presenter)
  }

  override fun render(state: MainViewState) {
    when (state) {
      is MainViewState.Error -> {
        retry.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        photosList.visibility = View.GONE
        typeSearch.visibility = View.GONE

      }

      is MainViewState.Loading -> {
        retry.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        photosList.visibility = View.GONE
        typeSearch.visibility = View.GONE

      }

      is MainViewState.EmptySearch -> {
        retry.visibility = View.GONE
        progressBar.visibility = View.GONE
        photosList.visibility = View.GONE
        typeSearch.visibility = View.VISIBLE
      }

      is MainViewState.ShowingFlickrImages -> {
        retry.visibility = View.GONE
        progressBar.visibility = View.GONE
        typeSearch.visibility = View.GONE


        photoListAdapter.photos = state.photos

        photosList.visibility = View.VISIBLE
      }
    }
  }


}


