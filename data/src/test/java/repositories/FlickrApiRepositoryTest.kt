package repositories

import api.FlickrApiRest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verifyNoMoreInteractions

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
    apiRepository.search("")

    Mockito.verify(apiRest).getImagesBySearch("")
  }
}