package main

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.ginzo.flirckrgallery.R
import com.ginzo.flirckrgallery.main.MainActivity
import com.ginzo.flirckrgallery.main.MainPresenter
import com.ginzo.flirckrgallery.main.MainViewState
import entities.Photo
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
  private val context = ApplicationProvider.getApplicationContext<Context>()

  @Rule
  @JvmField
  val activityRule = ActivityTestRule(MainActivity::class.java)

  private val activity: MainActivity
    get() = activityRule.activity

  private lateinit var presenter: MainPresenter

  private fun runOnUiThread(runnable: () -> Unit) {
    activity.runOnUiThread(runnable)
  }

  @Before
  fun init() {
    activityRule.launchActivity(Intent(context, MainActivity::class.java))
    presenter = activity.presenter
  }

  @Test
  fun renderLoading() {
    runOnUiThread {
      activity.render(MainViewState.Loading)
    }

    onView(withId(R.id.progressBar))
      .check(matches(isDisplayed()))

    onView(withId(R.id.photosList))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.typeSearch))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.retry))
      .check(matches(not(isDisplayed())))


  }

  @Test
  fun renderError() {
    runOnUiThread {
      activity.render(MainViewState.Error)
    }

    onView(withId(R.id.retry))
      .check(matches(isDisplayed()))

    onView(withId(R.id.progressBar))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.typeSearch))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.photosList))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.retry))
      .perform(click())
  }

  @Test
  fun renderEmptySearch() {
    runOnUiThread {
      activity.render(MainViewState.EmptySearch)
    }

    onView(withId(R.id.retry))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.progressBar))
      .check(matches(not(isDisplayed())))

    onView(withId(R.id.typeSearch))
      .check(matches(isDisplayed()))

    onView(withId(R.id.photosList))
      .check(matches(not(isDisplayed())))
  }
}