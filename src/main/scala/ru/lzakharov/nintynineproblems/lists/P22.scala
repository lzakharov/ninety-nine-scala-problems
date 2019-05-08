package ru.lzakharov.nintynineproblems.lists

import scala.collection.immutable.Nil

// P22 (*) Create a list containing all integers within a given range.
//     Example:
//     scala> range(4, 9)
//     res0: List[Int] = List(4, 5, 6, 7, 8, 9)

object P22 {
  def rangeBuiltin(start: Int, end: Int): List[Int] = List.range(start, end + 1)

  def rangeBuiltin2(start: Int, end: Int): List[Int] = (start to end).toList

  def rangeRecursive(start: Int, end: Int): List[Int] = {
    if (start > end) Nil
    else start :: rangeRecursive(start + 1, end)
  }

  def rangeTailRecursive(start: Int, end: Int): List[Int] = {
    def rangeTailRecursive(start: Int, end: Int, res: List[Int]): List[Int] = {
      if (start > end) res
      else rangeTailRecursive(start + 1, end, start :: res)
    }

    rangeTailRecursive(start, end, Nil)
  }
}
