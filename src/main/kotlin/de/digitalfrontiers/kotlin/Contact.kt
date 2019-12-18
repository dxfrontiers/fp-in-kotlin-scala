package de.digitalfrontiers.kotlin

import java.net.URL

data class Contact(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)

fun main() {

    println("Luhn (expected: true): ${isValid(49927398716L)}")
    println("Luhn (expected: false): ${isValid(49927398717L)}")

    println("Luhn (expected: true): ${LuhnTestHO.isValid(49927398716L)}")
    println("Luhn (expected: false): ${LuhnTestHO.isValid(49927398717L)}")

    val contact = Contact(
        firstName = "Max",
        lastName = "Mustermann",
        phoneNumber = "01234-567890"
    )

    val updatedContact = contact.copy(firstName = "Manuel")

    updatedContact.firstName

    divide(15, 4, 3)
    plus(3, 5)
    impurePlus(3, 5)

    buyCoffee(CreditCard()).runCatching {  }

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

fun buyCoffee(cc: CreditCard): Coffee {
    val coffee = Coffee()
    cc.charge(coffee.price)

    return coffee
}

class CreditCard {
    fun charge(amount: Double): Unit {

    }
}

data class Coffee(val price: Double = 1.337)