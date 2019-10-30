package entities

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoPageEntityTest {
  @Test
  fun parseFromJson() {
    val json = javaClass.classLoader!!.getResource("json/photo_page.json").readText()
    val jsonObject = JSONObject(json)

    assertEquals(
      PhotoPageEntity(
        page = 1,
        pages = 1725,
        photos = listOf(
          PhotoEntity(
            id = "48984498478",
            farm = 66,
            secret = "a3e92805ec",
            server = "65535"
          )
        )
      ),
      PhotoPageEntity.parseFromJson(jsonObject)
    )
  }

  @Test
  fun toDomain() {
    assertEquals(
      PhotoPage(1, 100, listOf(Photo("aa", "https://farm11.static.flickr.com/dd/aa_cc.jpg"))),
      PhotoPageEntity(1, 100, listOf(PhotoEntity("aa", 11, "cc", "dd"))).toDomain()
    )
  }
}