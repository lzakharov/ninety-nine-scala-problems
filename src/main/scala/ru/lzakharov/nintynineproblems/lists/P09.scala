package ru.lzakharov.nintynineproblems.lists

// P09 (**) Pack consecutive duplicates of list elements into sublists.
//     If a list contains repeated elements they should be placed in separate
//     sublists.
//
//     Example:
//     scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

object P09 {
  def pack[A](xs: List[A]): List[List[A]] = {
    if (xs.isEmpty) Nil
    else {
      val (packed, rest) = xs.span(_ == xs.head)
      packed :: pack(rest)
    }
  }
}
