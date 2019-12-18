package de.digitalfrontiers.scala

import java.io.InputStream
import java.net.URL

import scala.collection.immutable.TreeSet
import scala.util.Try

object Main {
  def main(args: Array[String]): Unit = {

    val chars = List("a", "b", "c", "d")

    val rest = chars.tail

    println(rest)

    val xs = TreeSet(6, 1, 3, 2, 4, 7, 8)
    // TreeSet(1, 2, 3, 4, 6, 7, 8)

    val ys = xs + 5
    // TreeSet(1, 2, 3, 4, 5, 6, 7, 8)


    println(xs)
    println(ys)


  }
}


class Test(userRepository: UserRepository, twitterRepository: TwitterRepository) {

  userRepository
    .findUserByEmail("varian.wrynn@azeroth.de")
    .filter(_.active)
    .flatMap(twitterRepository.findMostRecentPostByUser)
    .map(_.message)
    .foreach(println)


}

object TryStuff {

  def inputStreamForURL(urlString: String): InputStream = {
    try {
      val url = new URL(urlString)

      url.openConnection().getInputStream
    }
  }

}

object TryStuffWithTry {

  def inputStreamForURL(url: String): Try[InputStream] =
    Try(new URL(url))
      .flatMap(u => Try(u.openConnection()))
      .flatMap(conn => Try(conn.getInputStream))

}