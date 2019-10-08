object Solution {
  import collection.mutable
  def lastStoneWeight(stones: Array[Int]): Int = {
    val q = mutable.PriorityQueue[Int]()
    for (s <- stones) {
      q.enqueue(s)
    }
    while (q.length > 1) {
      val fst = q.dequeue
      val snd = q.dequeue
      val newEl = math.abs(fst-snd)
      if (newEl > 0)
        q.enqueue(newEl)
    }
    if (q.nonEmpty) q.dequeue
    else 0
  }
}