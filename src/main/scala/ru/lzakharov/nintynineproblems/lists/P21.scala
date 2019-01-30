package ru.lzakharov.nintynineproblems.lists

// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

object P21 {
  def insertAtBuiltin[A](x: A, n: Int, xs: List[A]): List[A] = xs.take(n) ::: (x :: xs.drop(n))

  def insertAtBuiltin2[A](x: A, n: Int, xs: List[A]): List[A] = xs.splitAt(n) match {
    case (left, right) => left ::: (x :: right)
  }
}
