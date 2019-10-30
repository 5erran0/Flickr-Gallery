package repositories

import api.FlickrApiRest
import entities.PhotoPageEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*

class FlickrApiRepositoryTest {
  private val apiRest: FlickrApiRest = mock(FlickrApiRest::class.java)

  private val apiRepository = FlickrApiRepository(apiRest)

  @After
  fun tearDown() {
    verifyNoMoreInteractions(apiRest)
  }

  @ExperimentalCoroutinesApi
  @Test
  fun search() = runBlockingTest {
    `when`(apiRest.getImagesBySearch("", 1)).thenReturn(
      mock(PhotoPageEntity::class.java)
    )

    apiRepository.search("", 1)

    verify(apiRest).getImagesBySearch("", 1)
  }

  @ExperimentalCoroutinesApi
  @Test
  fun getImageFromUrl() = runBlockingTest {
    apiRepository.getImageFromUrl("")

    verify(apiRest).getImageFromUrl("")
  }
}