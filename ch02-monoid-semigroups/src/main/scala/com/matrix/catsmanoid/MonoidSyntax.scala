package com.matrix.catsmanoid

import cats.kernel.Monoid

object MonoidSyntax extends App {
  import cats.instances.string._ // for Monoid
  import cats.syntax.semigroup._ // for |+|
  val stringResult = "Hi " |+| "there" |+| Monoid[String].empty
  // stringResult: String = Hi there
  import cats.instances.int._ // for Monoid
  val intResult = 1 |+| 2 |+| Monoid[Int].empty
  // intResult: Int = 3


}
