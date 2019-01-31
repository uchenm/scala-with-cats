package com.matrix.catfunctors

object TreeFunctorApp extends App {

 import cats.Functor
 import cats.syntax.functor._

 implicit val treeFunctor: Functor[Tree] =
  new Functor[Tree] {
   def map[A, B](tree: Tree[A])(func: A => B): Tree[B] =
    tree match {
     case Branch(left, right) =>
      Branch(map(left)(func), map(right)(func))
     case Leaf(value) =>
      Leaf(func(value))
    }
  }

// Branch(Leaf(10), Leaf(20)).map(_ * 2)
 // <console>:42: error: value map is not a member of wrapper.Branch[Int]
 //        Branch(Leaf(10), Leaf(20)).map(_ * 2)
 //                                   ^

 Tree.leaf(100).map(_ * 2)
 // res10: wrapper.Tree[Int] = Leaf(200)

 Tree.branch(Tree.leaf(10), Tree.leaf(20)).map(_ * 2)
 // res11: wrapper.Tree[Int] = Branch(Leaf(20),Leaf(40))

}
