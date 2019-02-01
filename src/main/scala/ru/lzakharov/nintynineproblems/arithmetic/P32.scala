package ru.lzakharov.nintynineproblems.arithmetic

// P32 (**) Determine the greatest common divisor of two positive integer
//          numbers.
//     Use Euclid's algorithm.
//
//     scala> gcd(36, 63)
//     res0: Int = 9

object P32 {
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
