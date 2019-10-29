package entities

import org.json.JSONObject

data class PhotoEntity(
  val id: String,
  val farm: Int,
  val secret: String,
  val server: String,
  val title: String
) {
  companion object {
    fun parseFromJson(json: JSONObject): PhotoEntity {
      return PhotoEntity(
        id = json.getString("id"),
        farm = json.getInt("farm"),
        secret = json.getString("secret"),
        server = json.getString("server"),
        title = json.getString("title")
      )
    }
  }

  fun toDomain(): Photo {
    return Photo(id, farm, secret, server, title)
  }
}