package ru.lzakharov.nintynineproblems.lists

// P02 (*) Find the last but one element of a list.
//     Example:
//     scala> penultimate(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 5

object P02 {
  def lastButOneBuiltin[A](xs: List[A]): A =
    if (xs.isEmpty) throw new NoSuchElementException
    else xs.init.last

  def lastButOneRecursive[A](xs: List[A]): A = xs match {
    case Nil | _ :: Nil => throw new NoSuchElementException
    case x :: _ :: Nil => x
    case _ :: tail => lastButOneRecursive(tail)
  }
}
