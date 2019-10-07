class RecentCounter() {
  import scala.collection.immutable
  var q = immutable.Queue[Int]()
  def ping(t: Int): Int = {
    while (q.nonEmpty && t-q.head > 3000)
      q = q.dequeue._2
    q = q.enqueue(t)
    q.size
  }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = new RecentCounter()
 * var param_1 = obj.ping(t)
 */