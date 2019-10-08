object Solution {
  import scala.collection.mutable
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val freqs = Array.fill(1001)(0)
    //build frequencies, freq_n <- frequency of n
    for (n <- arr1) {
      freqs(n) += 1
    }
    var absPosi = -1
    val arr2Set = mutable.Set[Int]()
    //build final position in the ordered array of arr2 members
    //freq_n <- max index of n in resulting array
    //ordering 'relative' to their position in arr2
    for (n <- arr2; if freqs(n) > 0) {
      arr2Set += n
      absPosi += freqs(n)
      freqs(n) = absPosi
    }
    //do the same thing for the arr1 elements not in arr2
    //the ordering now is the natural int ordering
    for (n <- 0 until 1001; if !arr2Set.contains(n)) {
      absPosi += freqs(n)
      freqs(n) = absPosi
    }
    var res = Array.fill(arr1.length)(0)
    //build the results array placing each element
    for (n <- arr1) {
      res(freqs(n)) = n
      freqs(n) -= 1
    }
    res
  }
}