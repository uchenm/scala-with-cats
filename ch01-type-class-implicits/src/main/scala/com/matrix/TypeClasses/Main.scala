package com.matrix.TypeClasses

object Main extends App {

  import JsonWriterInstances._
  import JsonSyntax._

  //Person("Dave", "dave@example.com").toJson(personWriter)

  println(Person("Dave","dave@dae.org").toJson)

}
