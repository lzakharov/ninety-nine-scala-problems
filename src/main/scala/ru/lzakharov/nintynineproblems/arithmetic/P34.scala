package ru.lzakharov.nintynineproblems.arithmetic

// P34 (**) Calculate Euler's totient function phi(m).
//     Euler's so-called totient function phi(m) is defined as the number of
//     positive integers r (1 <= r < m) that are coprime to m.  As a special
//     case, phi(1) is defined to be 1.
//
//     scala> totient(10)
//     res0: Int = 4

import ru.lzakharov.nintynineproblems.arithmetic.P33.isCoprime

object P34 {
  def totient(m: Int): Int = if (m == 1) 1 else (1 until m).count(isCoprime(m, _))
}
