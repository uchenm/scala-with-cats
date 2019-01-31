package com.matrix.catsmanoid

object MonoidInstances extends App{

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
  import cats.instances.int._    // for Monoid
  import cats.instances.option._ // for Monoid

  val a = Option(22)
  // a: Option[Int] = Some(22)

  val b = Option(20)
  // b: Option[Int] = Some(20)

  Monoid[Option[Int]].combine(a, b)
  // res6: Option[Int] = Some(42)

  import cats.instances.string._ // for Monoid
  import cats.syntax.semigroup._ // for |+|

  val stringResult = "Hi " |+| "there" |+| Monoid[String].empty
  // stringResult: String = Hi there

  import cats.instances.int._ // for Monoid

  val intResult = 1 |+| 2 |+| Monoid[Int].empty
  // intResult: Int = 3

  "Scala" |+| " with " |+| "Cats"
  // res0: String = Scala with Cats

  Option(1) |+| Option(2)
  // res1: Option[Int] = Some(3)

  import cats.instances.map._ // for Monoid

  val map1 = Map("a" -> 1, "b" -> 2)
  val map2 = Map("b" -> 3, "d" -> 4)

  map1 |+| map2
  // res3: Map[String,Int] = Map(b -> 5, d -> 4, a -> 1)

  import cats.instances.tuple._  // for Monoid


  val tuple1 = ("hello", 123)
  val tuple2 = ("world", 321)

  tuple1 |+| tuple2
  // res6: (String, Int) = (helloworld,444)

}
