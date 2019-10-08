object Solution {
  import collection.mutable
  import util.control.Breaks.{breakable, break}
  lazy val primes = sieveTo(1000)
  val cache = mutable.Map[Int,Boolean]()
  def divisorGame(N: Int): Boolean = {
    if (N == 1) return false
    if (N == 2) return true
    if (cache.contains(N)) return cache(N)
    for (f <- factors(N).dropRight(1)) {
      cache(N) = !divisorGame(N-f)
      if (cache(N)) return true
    }
    false
  }
  def factors(n: Int): Array[Int] = {
    val res = mutable.ArrayBuffer[Int]()
    breakable {
      for (i <- primes) {
        if (i > math.sqrt(n)) break
        if (n % i == 0) res += i
      }
    }
    res += n
    res.toArray
  }
  private [this] def sieveTo(n: Int): Array[Int] = {
    val primes = Array.fill(n+1)(true)
    for (i <- 2 until math.sqrt(n).toInt; if primes(i)) {
      for (j <- 2*i to n by i) {
        primes(j) = false
      }
    }
    val res = mutable.ArrayBuffer[Int]()
    for (j <- 1 until primes.length; if primes(j)) {
      res += j
    }
    res.toArray
  }
}