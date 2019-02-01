package ru.lzakharov.nintynineproblems.arithmetic

// P36 (**) Determine the prime factors of a given positive integer (2).
//     Construct a list containing the prime factors and their multiplicity.
//
//     scala> primeFactorMultiplicity(315)
//     res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
//
//     Alternately, use a Map for the result.
//     scala> primeFactorMultiplicity(315)
//     res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

import ru.lzakharov.nintynineproblems.arithmetic.P35.primeFactors
import ru.lzakharov.nintynineproblems.lists.P10.encode

object P36 {
  def primeFactorMultiplicity(x: Int): List[(Int, Int)] = encode(primeFactors(x)).map(_.swap)
}
