package ru.lzakharov.nintynineproblems.arithmetic

// P40 (**) Goldbach's conjecture.
//     Goldbach's conjecture says that every positive even number greater than 2
//     is the sum of two prime numbers.  E.g. 28 = 5 + 23.  It is one of the
//     most famous facts in number theory that has not been proved to be correct
//     in the general case.  It has been numerically confirmed up to very large
//     numbers (much larger than Scala's Int can represent).  Write a function
//     to find the two prime numbers that sum up to a given even integer.
//
//     scala> goldbach(28)
//     res0: (Int, Int) = (5,23)

import ru.lzakharov.nintynineproblems.arithmetic.P31.{primes, isPrime}

object P40 {
  def goldbach(n: Int): (Int, Int) = {
    if (n % 2 == 1 || n <= 2) throw new IllegalArgumentException
    else primes.takeWhile(_ < n).find(x => isPrime(n - x)) match {
      case None =>
        println(n)
        throw new IllegalArgumentException
      case Some(x) => (x, n - x)
    }
  }
}
