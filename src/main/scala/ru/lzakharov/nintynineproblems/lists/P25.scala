package ru.lzakharov.nintynineproblems.lists

// P25 (*) Generate a random permutation of the elements of a list.
//     Hint: Use the solution of problem P23.
//
//     Example:
//     scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

import ru.lzakharov.nintynineproblems.lists.P23.randomSelectTailRecursive

object P25 {
  def randomPermuteBuiltin[A](xs: List[A]): List[A] = util.Random.shuffle(xs)

  def randomPermute[A](xs: List[A]): List[A] = randomSelectTailRecursive(xs.length, xs)
}
