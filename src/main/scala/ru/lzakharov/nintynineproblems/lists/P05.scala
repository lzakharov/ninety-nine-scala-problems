package ru.lzakharov.nintynineproblems.lists

// P05 (*) Reverse a list.
//     Example:
//     scala> reverse(List(1, 1, 2, 3, 5, 8))
//     res0: List[Int] = List(8, 5, 3, 2, 1, 1)

object P05 {
  def reverseBuiltin[A](xs: List[A]): List[A] = xs.reverse

  def reverseRecursive[A](xs: List[A]): List[A] = xs match {
    case Nil => Nil
    case head :: tail => reverseRecursive(tail) :+ head
  }

  def reverseTailRecursive[A](xs: List[A]): List[A] = {
    def reverseTailRecursive(xs: List[A], res: List[A]): List[A] = xs match {
      case Nil => res
      case head :: tail => reverseTailRecursive(tail, head :: res)
    }

    reverseTailRecursive(xs, Nil)
  }
}
