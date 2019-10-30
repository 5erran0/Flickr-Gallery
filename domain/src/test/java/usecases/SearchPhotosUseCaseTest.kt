package usecases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test
import org.mockito.Mockito.*
import repositories.FlickrRepository

class SearchPhotosUseCaseTest {
  private val repository: FlickrRepository = mock(FlickrRepository::class.java)

  private val useCase = SearchPhotosUseCase(repository)

  @After
  fun tearDown() {
    verifyNoMoreInteractions(repository)
  }

  @ExperimentalCoroutinesApi
  @Test
  fun search() = runBlockingTest {
    useCase.search("")

    verify(repository).search("")
  }
}