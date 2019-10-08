object Solution {
  import collection.mutable
  def allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    val res = new Array[Array[Int]](R*C)
    val visited = mutable.Set[(Int,Int)]()
    val q = mutable.Queue[(Int,Int)]()
    q.enqueue(r0->c0)
    visited += (r0->c0)
    var i = 0
    while(q.nonEmpty) {
      var current = q.dequeue
      res(i) = Array(current._1,current._2)
      i += 1
      adjacents(current)
        .filter(rc => valid(R,C,rc) && !visited(rc))
        .foreach(rc => { visited += rc; q.enqueue(rc) })
    }
    res
  }
  def adjacents(rc: (Int,Int)): Array[(Int,Int)] = {
    for (delta <- Array((0,1),(1,0),(0,-1),(-1,0)))
      yield (rc._1+delta._1,rc._2+delta._2)
  }
  def valid(R: Int, C:Int, rc: (Int,Int)): Boolean =
    rc._1 < R && rc._2 < C && rc._1 >= 0 && rc._2 >= 0
}