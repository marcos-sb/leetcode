object Solution {
  def peakIndexInMountainArray(A: Array[Int]): Int = {
    var i = 0;
    while (i < A.length-1 && A(i) < A(i+1)) {
      i += 1
    }
    i
  }
}