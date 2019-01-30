package ru.lzakharov.nintynineproblems.lists

// P16 (**) Drop every Nth element from a list.
//     Example:
//     scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

object P16 {
  def dropBuiltin[A](n: Int, xs: List[A]): List[A] = xs match {
    case Nil => Nil
    case _ => xs.take(n - 1) ::: dropBuiltin(n, xs.drop(n))
  }

  def dropRecursive[A](n: Int, xs: List[A]): List[A] = {
    def dropRecursive(xs: List[A], count: Int): List[A] =
      if (count > 0) xs.head :: dropRecursive(xs.tail, count + 1) else dropRecursive(xs.tail, n)

    dropRecursive(xs, n)
  }

  def dropTailRecursive[A](n: Int, xs: List[A]): List[A] = {
    def dropTailRecursive(xs: List[A], count: Int, res: List[A]): List[A] = (count, xs) match {
      case (_, Nil) => res.reverse
      case (1, _ :: tail) => dropTailRecursive(tail, n, res)
      case (_, head :: tail) => dropTailRecursive(tail, count - 1, head :: res)
    }

    dropTailRecursive(xs, n, Nil)
  }

  def dropWithFilter[A](n: Int, xs: List[A]): List[A] =
    xs.zipWithIndex.filter(x => (x._2 + 1) % n != 0).map(_._1)
}
