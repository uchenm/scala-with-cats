package com.matrix.catsmanoid

object MonoidsInCats extends App {

  import cats.Monoid
  import cats.instances.string._ // for Monoid
  Monoid[String].combine("Hi ", "there")
  // res0: String = Hi there
  Monoid[String].empty
  // res1: String = ""
  Monoid.apply[String].combine("Hi ", "there")
  // res2: String = Hi there
  Monoid.apply[String].empty
  // res3: String = ""
  import cats.Semigroup
  Semigroup[String].combine("Hi ", "there")
  // res4: String = Hi there

  import cats.Monoid
  import cats.instances.int._ // for Monoid
  Monoid[Int].combine(32, 10)
  // res5: Int = 42
  import cats.Monoid
  import cats.instances.int._ // for Monoid
  import cats.instances.option._ // for Monoid
  val a = Option(22)
  // a: Option[Int] = Some(22)
  val b = Option(20)
  // b: Option[Int] = Some(20)
  Monoid[Option[Int]].combine(a, b)
  // res6: Option[Int] = Some(42)
}
