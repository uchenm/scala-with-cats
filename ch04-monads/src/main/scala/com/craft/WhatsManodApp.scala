package com.craft

object WhatsManodApp extends App {
  def parseInt(str: String): Option[Int] =
    scala.util.Try(str.toInt).toOption
  def divide(a: Int, b: Int): Option[Int] =
    if(b == 0) None else Some(a / b)

  def stringDivideBy(aStr: String, bStr: String): Option[Int] =
    parseInt(aStr).flatMap { aNum =>
      parseInt(bStr).flatMap { bNum =>
        divide(aNum, bNum)
      }
    }

  println(stringDivideBy("6", "2"))
  // res1: Option[Int] = Some(3)
  println(stringDivideBy("6", "0"))
  // res2: Option[Int] = None

  println(stringDivideBy("6", "foo"))
  // res3: Option[Int] = None
  println(stringDivideBy("bar", "2"))
  // res4: Option[Int] = None

  def stringDivideBy2(aStr: String, bStr: String): Option[Int] =
    for {
      aNum <- parseInt(aStr)
      bNum <- parseInt(bStr)
      ans <- divide(aNum, bNum)
    } yield ans

  for {
    x <- (1 to 3).toList
    y <- (4 to 5).toList
  } yield (x, y)
  // res5: List[(Int, Int)] = List((1,4), (1,5), (2,4), (2,5), (3,4),  (3,5))


  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._
  def doSomethingLongRunning: Future[Int] = ???
  def doSomethingElseLongRunning: Future[Int] = ???
  def doSomethingVeryLongRunning: Future[Int] =
    for {
      result1 <- doSomethingLongRunning
      result2 <- doSomethingElseLongRunning
    } yield result1 + result2

  def doSomethingVeryLongRunning2: Future[Int] =
    doSomethingLongRunning.flatMap { result1 =>
      doSomethingElseLongRunning.map { result2 =>
        result1 + result2
      }
    }


  import scala.language.higherKinds
  trait Monad[F[_]] {
    def pure[A](value: A): F[A]

    def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

    def map[A, B](value: F[A])(func: A => B): F[B] =
      flatMap(value)(a => pure(func(a)))
  }


}
