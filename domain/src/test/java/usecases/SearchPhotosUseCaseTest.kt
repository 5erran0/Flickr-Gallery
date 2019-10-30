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
  fun search_noPage() = runBlockingTest {
    useCase.search("")

    verify(repository).search("", 1)
  }

  @ExperimentalCoroutinesApi
  @Test
  fun search_withPage() = runBlockingTest {
    useCase.search("", 4)

    verify(repository).search("", 4)
  }
}