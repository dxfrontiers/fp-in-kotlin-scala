package de.digitalfrontiers.kotlin

import java.net.URL

data class Contact(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
) {
    fun withPhoneNumber(phoneNumber: String) =
        copy(phoneNumber = phoneNumber)
}

fun main() {

    val contact = Contact(
        firstName = "Max",
        lastName = "Mustermann",
        phoneNumber = "01234-567890"
    )

    val updatedContact = contact.copy(phoneNumber = "01337-424242")

    val updatedContactWither = contact.withPhoneNumber("01337-424344")

    updatedContact.firstName
    updatedContactWither.firstName

    divide(15, 4, 3)
    plus(3, 5)
    impurePlus(3, 5)

    listOf(3, 4, 5).toMutableList()

    val f = {i: Int -> i > 3}.compose<Int, Int, Boolean> { i -> i * 2 }

    println(f(1))
    println(f(2))

    /*
      val url = new URL(urlString)

      url.openConnection().getInputStream

     */

    val urlString = ""


    urlString.runCatching {
        URL(this)
    }.mapCatching {
        it.openConnection()
    }.mapCatching {
        it.getInputStream()
    }.onSuccess {
        // do something with InputStream
    }.onFailure {
        // do something with Exception
    }

}

infix fun<V, T, R> Function1<T, R>.compose(before: (V) -> T): (V) -> R {
    return { v: V -> this(before(v)) }
}

fun divide(a: Int, b: Int, c: Int): Int {
    return a / (b - c)
}

fun plus(a: Int, b: Int): Int {
    return a + b
}

fun impurePlus(a: Int, b: Int): Int {
    println(a + b)
    return a + b;
}
