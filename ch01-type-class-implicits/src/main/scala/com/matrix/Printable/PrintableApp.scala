package com.matrix.Printable

object PrintableApp extends App {

  import com.matrix.Printable.PrintableInstances._

  val cat = Cat("Garfield", 38, "ginger and black")
  // cat: Cat = Cat(Garfield,38,ginger and black)

  Printable.print(cat)
  // Garfield is a 38 year-old ginger and black cat.

  import PrintableSyntax._

  Cat("Garfield", 38, "ginger and black").print
  // Garfield is a 38 year-old ginger and black cat.

  import java.util.Date

  new Date().print
  // <console>:23: error: could not find implicit value for parameter p: Printable[java.util.Date]
  //        new Date().print
  //                   ^
}
