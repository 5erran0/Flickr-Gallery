package entities

import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoEntityTest {

  @Test
  fun parseFromJson() {

  }

  @Test
  fun toDomain() {
    assertEquals(
      Photo("aa", "http://farm11.static.flickr.com/dd/aa_cc.jpg"),
      PhotoEntity("aa", 11, "cc", "dd").toDomain()
    )
  }
}