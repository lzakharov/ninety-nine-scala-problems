package ru.lzakharov.nintynineproblems.lists

// P23 (**) Extract a given number of randomly selected elements from a list.
//     Example:
//     scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
//     res0: List[Symbol] = List('e, 'd, 'a)
//
//     Hint: Use the answer to P20.

import ru.lzakharov.nintynineproblems.lists.P20.removeAtBuiltin

object P23 {
  def randomSelectIneffective[A](n: Int, xs: List[A]): List[A] = util.Random.shuffle(xs).take(n)

  def randomSelectRecursive[A](n: Int, xs: List[A]): List[A] = {
    val r = new util.Random

    def randomSelectRecursive(n: Int, xs: List[A]): List[A] = {
      if (n <= 0) xs
      else {
        val (rest, x) = removeAtBuiltin(r.nextInt(xs.length), xs)
        x :: randomSelectRecursive(n - 1, rest)
      }
    }

    randomSelectRecursive(n, xs)
  }

  def randomSelectTailRecursive[A](n: Int, xs: List[A]): List[A] = {
    val r = new util.Random

    def randomSelectTailRecursive(n: Int, xs: List[A], res: List[A]): List[A] = {
      if (n <= 0) res
      else {
        val (rest, x) = removeAtBuiltin(r.nextInt(xs.length), xs)
        randomSelectTailRecursive(n - 1, rest, x :: res)
      }
    }

    randomSelectTailRecursive(n, xs, Nil)
  }
}
