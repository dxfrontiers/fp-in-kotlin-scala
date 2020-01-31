package de.digitalfrontiers.scala

class List[+A] {
}

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]