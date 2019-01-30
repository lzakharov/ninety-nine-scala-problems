package ru.lzakharov.nintynineproblems.lists

// P03 (*) Find the Kth element of a list.
//     By convention, the first element in the list is element 0.
//
//     Example:
//     scala> nth(2, List(1, 1, 2, 3, 5, 8))
//     res0: Int = 2

object P03 {
  def nthBuiltin[A](xs: List[A], n: Int): A =
    if (n >= 0) xs(n)
    else throw new NoSuchElementException

  def nthRecursive[A](xs: List[A], n: Int): A = (xs, n) match {
    case (Nil, _) => throw new NoSuchElementException
    case _ if n < 0 => throw new NoSuchElementException
    case (x :: _, 0) => x
    case (_ :: tail, _) => nthRecursive(tail, n - 1)
  }
}
