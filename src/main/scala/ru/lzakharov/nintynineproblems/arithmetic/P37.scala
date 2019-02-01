package ru.lzakharov.nintynineproblems.arithmetic

// P37 (**) Calculate Euler's totient function phi(m) (improved).
//     See problem P34 for the definition of Euler's totient function.  If the
//     list of the prime factors of a number m is known in the form of problem
//     P36 then the function phi(m>) can be efficiently calculated as follows:
//     Let [[p_1, m_1], [p_2, m_2], [p_3, m_3], ...] be the list of prime
//     factors (and their multiplicities) of a given number m.  Then phi(m) can
//     be calculated with the following formula:
//
//     phi(m) = (p_1-1)*p_1^(m_1-1) * (p_2-1)*p_2^(m_2-1) * (p_3-1)*p_3^(m_3-1) * ...
//
//     Note that a^b stands for the bth power of a.

import ru.lzakharov.nintynineproblems.arithmetic.P36.primeFactorMultiplicity

object P37 {
  def totientImproved(x: Int): Int = primeFactorMultiplicity(x).foldLeft(1) {
    (acc, x) => acc * (x._1 - 1) * math.pow(x._1, x._2 - 1).toInt
  }
}
