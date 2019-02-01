package ru.lzakharov.nintynineproblems.arithmetic

// P33 (*) Determine whether two positive integer numbers are coprime.
//     Two numbers are coprime if their greatest common divisor equals 1.
//
//     scala> isCoprimeTo(35, 64)
//     res0: Boolean = true

import ru.lzakharov.nintynineproblems.arithmetic.P32.gcd

object P33 {
  def isCoprime(a: Int, b: Int): Boolean = gcd(a, b) == 1
}
