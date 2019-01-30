package ru.lzakharov.nintynineproblems.lists

// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

object P20 {
  def removeAtBuiltin[A](n: Int, xs: List[A]): (List[A], A) = (xs.take(n) ::: xs.drop(n + 1), xs(n))

  def removeAtBuiltin2[A](n: Int, xs: List[A]): (List[A], A) = xs.splitAt(n) match {
    case _ if n < 0 => throw new NoSuchElementException
    case (left, x :: right) => (left ::: right, x)
    case _ => throw new NoSuchElementException
  }
}
