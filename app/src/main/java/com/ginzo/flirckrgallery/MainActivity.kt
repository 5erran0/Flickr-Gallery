package com.ginzo.flirckrgallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

  private lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    presenter = MainPresenter(this)
    lifecycle.addObserver(presenter)
  }

  override fun render(state: MainViewState) {
    when (state) {
      is MainViewState.Error -> {
        /* no-op */
      }

      is MainViewState.Loading -> {
        /* no-op */
      }

      is MainViewState.ShowingFlickrImages -> {
        textView.text = state.string
      }
    }
  }
}
