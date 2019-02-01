package ru.lzakharov.nintynineproblems.arithmetic

// P31 (**) Determine whether a given integer number is prime.
//     scala> isPrime(7)
//     res0: Boolean = true

// A fairly naive implementation for primality testing is simply: a number is
// prime if it it not divisible by any prime number less than or equal to its
// square root.
// Here, we use a Stream to create a lazy infinite list of prime numbers.  The
// mutual recursion between `primes` and `isPrime` works because of the limit
// on `isPrime` to the square root of the number being tested.

object P31 {
  val primes = Stream.cons(2, Stream.from(3, 2).filter(isPrime))

  def isPrime(x: Int): Boolean = x > 1 && primes.takeWhile(_ <= math.sqrt(x).toInt).forall(x % _ != 0)
}
