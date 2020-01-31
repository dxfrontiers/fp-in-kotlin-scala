package de.digitalfrontiers.kotlin

import de.digitalfrontiers.kotlin.CoffeePure.CreditCard
import de.digitalfrontiers.kotlin.CoffeePure.buyCoffee

fun main() {
    buyCoffee(CreditCard())
}

object CoffeePure {

    fun buyCoffee(cc: CreditCard): Pair<Coffee, Charge> {
        val coffee = Coffee()

        return Pair(coffee, Charge(cc, coffee.price))
    }

    data class Charge(val cc: CreditCard, val amount: Double)

    class CreditCard {
        fun charge(amount: Double): Unit {

        }
    }

    data class Coffee(val price: Double = 1.337)

}
