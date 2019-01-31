package com.matrix.UsingCats

import java.util.Date

import cats.Show
import com.matrix.Printable.Cat

object UsingCats extends App {

  import cats.instances.int._ // for Show
  import cats.instances.string._ // for Show

  val showInt: Show[Int] = Show.apply[Int]
  val showString: Show[String] = Show.apply[String]

  val intAsString: String = showInt.show(123)
  // intAsString: String = 123

  val stringAsString: String = showString.show("abc")
  // stringAsString: String = abc


  import cats.syntax.show._ // for show

  val shownInt = 123.show
  // shownInt: String = 123

  val shownString = "abc".show
  // shownString: String = abc

  implicit val dateShow: Show[Date] =
    Show.show(date => s"${date.getTime}ms since the epoch.")

  println(new Date().show)


  import CatShowInstance._

  println(Cat("Garfield", 38, "ginger and black").show)
  // Garfield is a 38 year-old ginger and black cat.


}
