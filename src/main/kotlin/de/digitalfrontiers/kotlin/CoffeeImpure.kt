package de.digitalfrontiers.kotlin

import de.digitalfrontiers.kotlin.CoffeeImpure.CreditCard
import de.digitalfrontiers.kotlin.CoffeeImpure.buyCoffee

fun main() {
    buyCoffee(CreditCard()).runCatching {  }
}

object CoffeeImpure {

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

}
