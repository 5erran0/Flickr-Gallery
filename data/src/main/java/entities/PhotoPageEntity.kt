package entities

import org.json.JSONObject

data class PhotoPageEntity(
  val page: Int,
  val pages: Int,
  val photos: List<PhotoEntity>
) {
  companion object {
    fun parseFromJson(json: JSONObject): PhotoPageEntity {
      val photosJsonArray = json.getJSONArray("photo")
      val photos = mutableListOf<PhotoEntity>()

      for (i in 0 until photosJsonArray.length()) {
        val photoEntity = PhotoEntity.parseFromJson(photosJsonArray.getJSONObject(i))
        photos.add(photoEntity)
      }

      return PhotoPageEntity(
        page = json.getInt("page"),
        pages = json.getInt("pages"),
        photos = photos
      )
    }
  }

  fun toDomain(): PhotoPage {
    return PhotoPage(page, pages, photos.map { it.toDomain() })
  }
}