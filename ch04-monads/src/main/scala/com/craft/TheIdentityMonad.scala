package com.craft

object TheIdentityMonad extends App {
  import scala.language.higherKinds
  import cats.Monad
  import cats.syntax.functor._ // for map
  import cats.syntax.flatMap._ // for flatMap
  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x <- a
      y <- b
    } yield x*x + y*y

//  sumSquare(3, 4)
//error

  import cats.Id
  sumSquare(3 : Id[Int], 4 : Id[Int])
  // res2: cats.Id[Int] = 25

  val a = Monad[Id].pure(3)
  // a: cats.Id[Int] = 3
  val b = Monad[Id].flatMap(a)(_ + 1)
  // b: cats.Id[Int] = 4
  import cats.syntax.functor._ // for map
  import cats.syntax.flatMap._ // for flatMap
  for {
    x <- a
    y <- b
  } yield x + y
  // res6: cats.Id[Int] = 7
}
