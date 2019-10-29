package entities

data class Photo(
  val id: String,
  val farm: Int,
  val secret: String,
  val server: String,
  val title: String
)