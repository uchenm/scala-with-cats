package com.matrix.catsmanoid

object AddingAllTheThingsApp extends App {

  def add(items: List[Int]): Int =
    items.foldLeft(0)(_ + _)

  import cats.Monoid
  import cats.instances.int._    // for Monoid
  import cats.syntax.semigroup._ // for |+|

  def add1(items: List[Int]): Int =
    items.foldLeft(Monoid[Int].empty)(_ |+| _)

  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(_ |+| _)

//  def add[A: Monoid](items: List[A]): A =
//    items.foldLeft(Monoid[A].empty)(_ |+| _)



  add(List(1, 2, 3))
  // res9: Int = 6

  import cats.instances.option._ // for Monoid

  add(List(Some(1), None, Some(2), None, Some(3)))
  // res10: Option[Int] = Some(6)


  implicit val monoid: Monoid[Order] = new Monoid[Order] {
    def combine(o1: Order, o2: Order) =
      Order(
        o1.totalCost + o2.totalCost,
        o1.quantity + o2.quantity
      )

    def empty = Order(0, 0)
  }

}
