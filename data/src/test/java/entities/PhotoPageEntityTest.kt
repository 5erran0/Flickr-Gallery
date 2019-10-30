package entities

import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoPageEntityTest {
  @Test
  fun parseFromJson() {

  }

  @Test
  fun toDomain() {
    assertEquals(
      PhotoPage(1, 100, listOf(Photo("aa", "http://farm11.static.flickr.com/dd/aa_cc.jpg"))),
      PhotoPageEntity(1, 100, listOf(PhotoEntity("aa", 11, "cc", "dd"))).toDomain()
    )
  }
}

