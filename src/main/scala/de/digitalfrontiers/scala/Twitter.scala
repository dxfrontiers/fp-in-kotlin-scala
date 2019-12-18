package de.digitalfrontiers.scala

trait UserRepository {
  def findUserByEmail(email: String): Option[User]
}

trait TwitterRepository {
  def findMostRecentPostByUser(user: User): Option[TwitterPost]
}

case class User(
  active: Boolean
)

case class TwitterPost(
  message: String
)
