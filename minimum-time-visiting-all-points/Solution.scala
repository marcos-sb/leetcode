object Solution {
  def minTimeToVisitAllPoints(points: Array[Array[Int]]): Int = {
    points.sliding(2).map(a => minDistance(a(0),a(1))).sum
  }
  def minDistance(pa: Array[Int], pb: Array[Int]): Int = {
    val dst = Array(pb(0)-pa(0), pb(1)-pa(1)).map(math.abs)
    val _min = dst.min
    val _diff = math.abs(dst(0)-dst(1))
    _min + _diff
  }
}