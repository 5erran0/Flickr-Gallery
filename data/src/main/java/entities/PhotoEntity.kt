package entities

data class PhotoEntity(
  val farm: Int,
  val id: String,
  val isFamily: Int,
  val isFriend: Int,
  val isPublic: Int,
  val owner: String,
  val secret: String,
  val server: String,
  val title: String
)