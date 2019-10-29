package entities

data class PhotoPage(
  val page: Int,
  val pages: Int,
  val photos: List<Photo>
)