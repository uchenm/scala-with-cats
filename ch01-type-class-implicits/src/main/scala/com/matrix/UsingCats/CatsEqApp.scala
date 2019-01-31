package com.matrix.UsingCats

import com.matrix.Printable.Cat

object CatsEqApp extends App {

  import cats.Eq


  import cats.instances.int._ // for Eq

  val eqInt = Eq[Int]

  eqInt.eqv(123, 123)
  // res2: Boolean = true

  eqInt.eqv(123, 234)
  // res3: Boolean = false

  import cats.syntax.eq._ // for === and =!=

  123 === 123
  // res5: Boolean = true

  123 =!= 234
  // res6: Boolean = true
  //Again, comparing values of different types causes a compiler error:
  //  123 === "123"


  import cats.instances.int._    // for Eq
  import cats.instances.option._ // for Eq

//  Some(1) === None
  (Some(1) : Option[Int]) === (None : Option[Int])
  // res9: Boolean = false

  Option(1) === Option.empty[Int]
  // res10: Boolean = false

  import cats.syntax.option._ // for some and none

  1.some === none[Int]
  // res11: Boolean = false

  1.some =!= none[Int]
  // res12: Boolean = true

  import java.util.Date
  import cats.instances.long._ // for Eq

  implicit val dateEq: Eq[Date] =
    Eq.instance[Date] { (date1, date2) =>
      date1.getTime === date2.getTime
    }
  val x = new Date() // now
  val y = new Date() // a bit later than now

  x === x
  // res13: Boolean = true

  x === y
  // res14: Boolean = false



  import CatShowInstance._

  val cat1 = Cat("Garfield",   38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")

  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  optionCat1===optionCat2


}
