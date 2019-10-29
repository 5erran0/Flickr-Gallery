package entities

data class PhotoPageEntity(
  val page: Int,
  val pages: Int,
  val photos: List<PhotoEntity>
)