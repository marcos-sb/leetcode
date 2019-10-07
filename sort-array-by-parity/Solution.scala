object Solution {
  def sortArrayByParity(A: Array[Int]): Array[Int] = {
    //solution #1: O(N) space
    //val parted = A.partition(_ % 2 == 0)
    //(parted._1 ++ parted._2).toArray

    //solution #2 (in-place): O(1) space
    def swap(_a: Array[Int], x:Int, y:Int) {
      val tmp = _a(x)
      _a(x) = _a(y)
      _a(y) = tmp
    }

    var j = A.size-1 //first odd position from the right
    for (i <- 0 until A.size) {
      if (A(i) % 2 == 1) {
        while (j > i && A(j) % 2 != 0) j -= 1
        if (j == i) return A
        else swap(A,i,j)
      }
    }
    A
  }
}