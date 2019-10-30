package entities

import org.json.JSONObject

data class PhotoEntity(
  val id: String,
  val farm: Int,
  val secret: String,
  val server: String
  ) {

  companion object {
    fun parseFromJson(json: JSONObject): PhotoEntity {
      return PhotoEntity(
        id = json.getString("id"),
        farm = json.getInt("farm"),
        secret = json.getString("secret"),
        server = json.getString("server")
      )
    }
  }

  fun toDomain(): Photo {
    return Photo(id, "https://farm$farm.static.flickr.com/$server/${id}_$secret.jpg")
  }
}