package com.matrix.catfunctors

object CatFunctorExamplesApp extends App {


 import scala.language.higherKinds
 import cats.Functor
 import cats.instances.list._   // for Functor
 import cats.instances.option._ // for Functor


 val list1 = List(1, 2, 3)
 // list1: List[Int] = List(1, 2, 3)
  List(1, 2, 3).map(n => n + 1)
  // res0: List[Int] = List(2, 3, 4)

 val list2 = Functor[List].map(list1)(_ * 2)
 // list2: List[Int] = List(2, 4, 6)
  List(1, 2, 3).
    map(n => n + 1).
    map(n => n * 2).
    map(n => n + "!")
  // res1: List[String] = List(4!, 6!, 8!)

 val option1 = Option(123)
 // option1: Option[Int] = Some(123)

 val option2 = Functor[Option].map(option1)(_.toString)
 // option2: Option[String] = Some(123)

 println(option2)


 val func = (x: Int) => x + 1
 // func: Int => Int = <function1>

 val liftedFunc = Functor[Option].lift(func)
 // liftedFunc: Option[Int] => Option[Int] = cats.Functor$$Lambda$12952/101985314@120e192a
 println(liftedFunc(Option(1)))
 // res0: Option[Int] = Some(2)

 import cats.instances.function._ // for Functor
 import cats.syntax.functor._     // for map

 val func1 = (a: Int) => a + 1
 val func2 = (a: Int) => a * 2
 val func3 = (a: Int) => a + "!"
// val func4 = func1.map(func2).map(func3)
//
// func4(123)
// // res1: String = 248!



 def doMath[F[_]](start: F[Int])
                 (implicit functor: Functor[F]): F[Int] =
  start.map(n => n + 1 * 2)

 import cats.instances.option._ // for Functor
 import cats.instances.list._   // for Functor

 println(doMath(Option(20)))
 // res3: Option[Int] = Some(22)

 println(doMath(List(1, 2, 3)))
 // res4: List[Int] = List(3, 4, 5)

//  implicit class FunctorOps[F[_], A](src: F[A]) {
//    def map[B](func: A => B)
//              (implicit functor: Functor[F]): F[B] =
//      functor.map(src)(func)
//  }



}
