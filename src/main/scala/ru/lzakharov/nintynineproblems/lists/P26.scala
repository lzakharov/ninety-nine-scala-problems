package ru.lzakharov.nintynineproblems.lists

import scala.annotation.tailrec

// P26 (**) Generate the combinations of K distinct objects chosen from the N
//          elements of a list.
//     In how many ways can a committee of 3 be chosen from a group of 12
//     people?  We all know that there are C(12,3) = 220 possibilities (C(N,K)
//     denotes the well-known binomial coefficient).  For pure mathematicians,
//     this result may be great.  But we want to really generate all the possibilities.
//
//     Example:
//     scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

object P26 {
  // combination_0 = Nil
  //
  // combination_n(x1, x2, ..., xn) = (
  //   combination_{n-1}(x2, ..., xn) map (x1 :: _),
  //   combination_{n-1}(x3, ..., ) map (x1 :: _)),
  //   ...,
  //   combination_{n-1}() map (x_1 :: _))

  def flatMapSublists[A, B](xs: List[A])(f: List[A] => List[B]): List[B] =
    xs match {
      case Nil => Nil
      case sublist@_ :: tail => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations[A](n: Int, xs: List[A]): List[List[A]] = {
    if (n == 0) Nil
    else flatMapSublists(xs)(sublist => combinations(n - 1, sublist).map(xs.head :: _))
  }
}
