object Solution {
  def countPrimeSetBits(L: Int, R: Int): Int = {
    val prime = sieveTo(32)
    var count = 0
    for (n <- L to R) {
      if (prime(bitsSet(n))) count += 1
    }
    count
  }
  private [this] def sieveTo(n: Int): Array[Boolean] = {
    val primes = Array.fill(n+1)(true)
    primes(0) = false
    primes(1) = false
    for (i <- primes.indices.drop(2).takeWhile(_ < math.sqrt(n)); if primes(i))
      for (j <- i * 2 to n by i) {
        primes(j) = false
      }
    primes
  }
  private [this] def bitsSet(n: Int): Int = {
    var _n = n
    var count = 0
    while (_n > 0) {
      if ((_n & 1) == 1) {
        count += 1
      }
      _n >>= 1
    }
    count
  }
}