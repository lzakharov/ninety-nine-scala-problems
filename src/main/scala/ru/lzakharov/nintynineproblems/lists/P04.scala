package ru.lzakharov.nintynineproblems.lists

// P04 (*) Find the number of elements of a list.
//     Example:
//     scala> length(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 6

object P04 {
  def lengthBuiltin[A](xs: List[A]): Int = xs.length

  def lengthRecursive[A](xs: List[A]): Int = xs match {
    case Nil => 0
    case _ :: tail => 1 + lengthRecursive(tail)
  }

  def lengthTailRecursive[A](xs: List[A]): Int = {
    def lengthTailRecursive(xs: List[A], n: Int): Int = xs match {
      case Nil => n
      case _ :: tail => lengthTailRecursive(tail, n + 1)
    }
    lengthTailRecursive(xs, 0)
  }
}
