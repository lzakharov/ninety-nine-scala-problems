package ru.lzakharov.nintynineproblems.lists

// P17 (*) Split a list into two parts.
//     The length of the first part is given.  Use a Tuple for your result.
//
//     Example:
//     scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

object P17 {
  def splitBuiltin[A](n: Int, xs: List[A]): (List[A], List[A]) = xs.splitAt(n)

  def splitByTakeAndDrop[A](n: Int, xs: List[A]): (List[A], List[A]) =
    (xs.take(n), xs.drop(n))

  def splitRecursive[A](n: Int, xs: List[A]): (List[A], List[A]) = (n, xs) match {
    case (_, Nil) => (Nil, Nil)
    case (0, _) => (Nil, xs)
    case (_, head :: tail) =>
      val (left, right) = splitRecursive(n - 1, tail)
      (head :: left, right)
  }

  def splitTailRecursive[A](n: Int, xs: List[A]): (List[A], List[A]) = {
    def splitTailRecursive(n: Int, left: List[A], right: List[A]): (List[A], List[A]) = (n, xs) match {
      case (_, Nil) => (left.reverse, Nil)
      case _ if n <= 0 => (left.reverse, right)
      case (_, head :: tail) => splitTailRecursive(n - 1, head :: left, tail)
    }

    splitTailRecursive(n, Nil, xs)
  }
}
