package ru.lzakharov.nintynineproblems.arithmetic

// P35 (**) Determine the prime factors of a given positive integer.
//     Construct a flat list containing the prime factors in ascending order.
//
//     scala> 315.primeFactors
//     res0: List[Int] = List(3, 3, 5, 7)

import ru.lzakharov.nintynineproblems.arithmetic.P31._

object P35 {
  def primeFactors(x: Int): List[Int] = {
    def primeFactors(x: Int, primes: Stream[Int], factors: List[Int]): List[Int] = {
      if (x == 1) factors.reverse
      else if (x % primes.head == 0) primeFactors(x / primes.head, primes, primes.head :: factors)
      else primeFactors(x, primes.tail, factors)
    }

    primeFactors(x, primes, Nil)
  }
}
