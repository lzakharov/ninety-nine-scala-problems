package ru.lzakharov.nintynineproblems.arithmetic

// P38 (*) Compare the two methods of calculating Euler's totient function.
//     Use the solutions of problems P34 and P37 to compare the algorithms.  Try
//     to calculate phi(10090) as an example.

import ru.lzakharov.nintynineproblems.arithmetic.P31.primes
import ru.lzakharov.nintynineproblems.arithmetic.P34.totient
import ru.lzakharov.nintynineproblems.arithmetic.P37.totientImproved

object P38 {
  def timeIt(label: String)(block: => Any): Unit = {
    val now = System.currentTimeMillis()
    block
    println(s"$label: ${System.currentTimeMillis() - now} ms.")
  }

  def test(n: Int): Unit = {
    timeIt("prepare primes") {
      primes.takeWhile(_ <= math.sqrt(n)).force
    }

    timeIt("simple totient") {
      totient(n)
    }

    timeIt("improved totient") {
      totientImproved(n)
    }
  }
}
