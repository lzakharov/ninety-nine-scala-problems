package ru.lzakharov.nintynineproblems.arithmetic

// P39 (*) A list of prime numbers.
//     Given a range of integers by its lower and upper limit, construct a list
//     of all prime numbers in that range.
//
//     scala> listPrimesInRange(7, 31)
//     res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

import ru.lzakharov.nintynineproblems.arithmetic.P31.primes

object P39 {
  def listPrimesInRange(range: Range): List[Int] = primes.dropWhile(_ < range.head).takeWhile(_ <= range.last).toList
}
