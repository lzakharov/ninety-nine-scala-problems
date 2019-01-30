package ru.lzakharov.nintynineproblems.lists

// P18 (**) Extract a slice from a list.
//     Given two indices, I and K, the slice is the list containing the elements
//     from and including the Ith element up to but not including the Kth
//     element of the original list.  Start counting the elements with 0.
//
//     Example:
//     scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g)

object P18 {
  def sliceBuiltin[A](from: Int, until: Int, xs: List[A]): List[A] = xs.slice(from, until)

  def sliceRecursive[A](from: Int, until: Int, xs: List[A]): List[A] = (from, until, xs) match {
    case (_, _, Nil) | _ if until <= 0 => Nil
    case (_, _, head :: tail) if from <= 0 => head :: sliceRecursive(0, until - 1, tail)
    case (_, _, _ :: tail) if from > 0 => sliceRecursive(from - 1, until - 1, tail)
  }

  def sliceTailRecursive[A](from: Int, until: Int, xs: List[A]): List[A] = {
    def sliceTailRecursive(from: Int, until: Int, xs: List[A], res: List[A]): List[A] = (from, until, xs) match {
      case (_, _, Nil) | _ if until <= 0 => res.reverse
      case (_, _, head :: tail) if from <= 0 => sliceTailRecursive(from - 1, until - 1, tail, head :: res)
      case (_, _, _ :: tail) if from > 0 => sliceTailRecursive(from - 1, until - 1, tail, res)
    }

    sliceTailRecursive(from, until, xs, Nil)
  }

  def sliceTailRecursive2[A](from: Int, until: Int, xs: List[A]): List[A] = {
    def sliceTailRecursive(from: Int, until: Int, xs: List[A], res: List[A]): List[A] = {
      if (xs.isEmpty || until <= 0) res.reverse
      else sliceTailRecursive(from - 1, until - 1, xs.tail, if (from > 0) res else xs.head :: res)
    }

    sliceTailRecursive(from, until, xs, Nil)
  }
}
