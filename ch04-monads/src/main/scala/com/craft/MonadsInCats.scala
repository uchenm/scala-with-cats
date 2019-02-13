package com.craft

object MonadsInCats {
  import cats.Monad
  import cats.instances.option._ // for Monad
  import cats.instances.list._ // for Monad
  val opt1 = Monad[Option].pure(3)
  // opt1: Option[Int] = Some(3)
  val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))
  // opt2: Option[Int] = Some(5)
  val opt3 = Monad[Option].map(opt2)(a => 100 * a)
  // opt3: Option[Int] = Some(500)

  val list1 = Monad[List].pure(3)
  // list1: List[Int] = List(3)
  val list2 = Monad[List].flatMap(List(1, 2, 3))(a => List(a, a*10))
  // list2: List[Int] = List(1, 10, 2, 20, 3, 30)

  val list3 = Monad[List].map(list2)(a => a + 123)
  // list3: List[Int] = List(124, 133, 125, 143, 126, 153)

  import cats.instances.option._ // for Monad
  Monad[Option].flatMap(Option(1))(a => Option(a*2))
  // res0: Option[Int] = Some(2)
  import cats.instances.list._ // for Monad
  Monad[List].flatMap(List(1, 2, 3))(a => List(a, a*10))
  // res1: List[Int] = List(1, 10, 2, 20, 3, 30)
  import cats.instances.vector._ // for Monad
  Monad[Vector].flatMap(Vector(1, 2, 3))(a => Vector(a, a*10))
  // res2: Vector[Int] = Vector(1, 10, 2, 20, 3, 30)

  import cats.instances.future._ // for Monad
  import scala.concurrent._
  import scala.concurrent.duration._
  import scala.concurrent.ExecutionContext.Implicits.global
  val fm = Monad[Future]

  val future = fm.flatMap(fm.pure(1))(x => fm.pure(x + 2))
  Await.result(future, 1.second)
  // res3: Int = 3
}
