package ru.lzakharov.nintynineproblems.lists

// P01 (*) Find the last element of a list.
//     Example:
//     scala> last(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 8

object P01 {
  def lastBuiltin[A](xs: List[A]): A = xs.last

  def lastRecursive[A](xs: List[A]): A = xs match {
    case Nil => throw new NoSuchElementException
    case x :: Nil => x
    case _ :: tail => lastRecursive(tail)
  }
}
