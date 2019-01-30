package ru.lzakharov.nintynineproblems.lists

// P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//     Example:
//     scala> lotto(6, 49)
//     res0: List[Int] = List(23, 1, 17, 33, 21, 37)

import ru.lzakharov.nintynineproblems.lists.P23.randomSelectTailRecursive

object P24 {
  def lotto(n: Int, m: Int): List[Int] =
    randomSelectTailRecursive(n, List.range(1, m + 1))
}
