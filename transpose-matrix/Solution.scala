object Solution {
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
    val At = Array.fill(A(0).length,A.length)(0)
    for (r <- A.indices; c <- A(0).indices) {
      At(c)(r) = A(r)(c)
    }
    At
  }
}