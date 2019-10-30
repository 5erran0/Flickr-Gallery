package usecases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test
import org.mockito.Mockito
import repositories.FlickrRepository

class GetImageFromUrlUseCaseTest {
  private val repository: FlickrRepository = Mockito.mock(FlickrRepository::class.java)

  private val useCase = GetImageFromUrlUseCase(repository)

  @After
  fun tearDown() {
    Mockito.verifyNoMoreInteractions(repository)
  }

  @ExperimentalCoroutinesApi
  @Test
  fun search() = runBlockingTest {
    useCase.getImageFromUrl("")

    Mockito.verify(repository).getImageFromUrl("")
  }
}