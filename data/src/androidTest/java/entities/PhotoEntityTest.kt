package entities

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoEntityTest {

  @Test
  fun parseFromJson() {
    val json = javaClass.classLoader!!.getResource("json/photo.json").readText()
    val jsonObject = JSONObject(json)

    assertEquals(
      PhotoEntity(id = "48984498478", farm = 66, secret = "a3e92805ec", server = "65535"),
      PhotoEntity.parseFromJson(jsonObject)
    )
  }

  @Test
  fun toDomain() {
    assertEquals(
      Photo("aa", "https://farm11.static.flickr.com/dd/aa_cc.jpg"),
      PhotoEntity("aa", 11, "cc", "dd").toDomain()
    )
  }
}