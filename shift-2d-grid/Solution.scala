object Solution {
  def shiftGrid(grid: Array[Array[Int]], k: Int): List[List[Int]] = {
    val rs = grid.length
    val cs = grid(0).length
    val modk = k % (rs * cs)
    val finalPos = new Array[Int](rs*cs)

    var n = 0
    for (i <- modk until finalPos.length) {
      finalPos(n) = i
      n += 1
    }
    for (i <- 0 until modk) {
      finalPos(n) = i
      n += 1
    }

    val res = Array.fill(rs,cs)(0)
    n = 0
    for (r <- grid.indices; c <- grid(0).indices)  {
      res(finalPos(n)/cs)(finalPos(n)%cs) = grid(r)(c)
      n += 1
    }
    res.map(_.toList).toList
  }
}