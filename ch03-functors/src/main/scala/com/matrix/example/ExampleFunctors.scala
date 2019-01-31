package com.matrix.example

object ExampleFunctors extends App {

  List(1, 2, 3).
    map(n => n + 1).
    map(n => n * 2).
    map(n => n + "!")
  // res1: List[String] = List(4!, 6!, 8!)

  import scala.concurrent.{Future, Await}
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._

  val future: Future[String] =
    Future(123).
      map(n => n + 1).
      map(n => n * 2).
      map(n => n + "!")

  val result= Await.result(future, 1.second)
  // res3: String = 248!

  println(result)

  import scala.util.Random

  val future1 = {
    // Initialize Random with a fixed seed:
    val r = new Random(0L)

    // nextInt has the side-effect of moving to
    // the next random number in the sequence:
    val x = Future(r.nextInt)
    for {
      a <- x
      b <- x
    } yield (a, b)
  }

  val future2 = {
    val r = new Random(0L)

    for {
      a <- Future(r.nextInt)
      b <- Future(r.nextInt)
    } yield (a, b)
  }

  val result1 = Await.result(future1, 1.second)
  // result1: (Int, Int) = (-1155484576,-1155484576)

  val result2 = Await.result(future2, 1.second)
  // result2: (Int, Int) = (-1155484576,-723955400)

  println(result1)
  println(result2)


  import cats.instances.function._ // for Functor
  import cats.syntax.functor._     // for map

  val func1: Int => Double =
    (x: Int) => x.toDouble

  val func2: Double => Double =
    (y: Double) => y * 2




//  (func1 map func2)(1)     // composition using map

  // res7: Double = 2.0
  (func1 andThen func2)(1) // composition using andThen
  // res8: Double = 2.0

  func2(func1(1))          // composition written out by hand
  // res9: Double = 2.0

}
