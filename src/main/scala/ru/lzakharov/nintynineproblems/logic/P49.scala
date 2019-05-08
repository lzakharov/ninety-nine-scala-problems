package ru.lzakharov.nintynineproblems.logic

import scala.collection.mutable

// P49 (**) Gray code.
//     An n-bit Gray code is a sequence of n-bit strings constructed according
//     to certain rules. For example,
//     n = 1: C(1) = ("0", "1").
//     n = 2: C(2) = ("00", "01", "11", "10").
//     n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
//
//     Find out the construction rules and write a function to generate Gray
//     codes.
//
//     scala> gray(3)
//     res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
//
//     See if you can use memoization to make the function more
//     efficient.

object P49 {
  def gray(n: Int): List[String] = n match {
    case 0 => List("")
    case _ =>
      val origin = gray(n - 1)
      origin.map("0" + _) ::: origin.reverse.map("1" + _)
  }

  private val memory = mutable.Map(0 -> List(""))

  def grayMemorized(n: Int): List[String] = {
    if (!memory.contains(n)) memory(n) = grayMemorized(n - 1).map("0" + _) ::: grayMemorized(n - 1).reverse.map("1" + _)
    memory(n)
  }
}
