package com.matrix.UsingCats

import cats.Show
import com.matrix.Printable.Cat

object CatShowInstance {

  import cats.Show
  import cats.instances.int._    // for Show
  import cats.instances.string._ // for Show
  import cats.syntax.show._      // for show

  implicit val catShow = Show.show[Cat] { cat =>
    val name  = cat.name.show
    val age   = cat.age.show
    val color = cat.color.show
    s"$name is a $age year-old $color cat."
  }


  import cats.Eq
  import cats.syntax.eq._ // for ===
  implicit val catEqual: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      (cat1.name  === cat2.name ) &&
        (cat1.age   === cat2.age  ) &&
        (cat1.color === cat2.color)
    }

}
