class MyHashSet() {
  //Impl. as a bitset with longs
  private val buckets = Array.fill(1000000/64 + 1)(0L)

  def add(key: Int): Unit = {
    val bucket = key / 64
    val bucketDelta = key % 64
    val mask = 1L << bucketDelta
    buckets(bucket) |= mask
  }

  def remove(key: Int): Unit = {
    val bucket = key / 64
    val bucketDelta = key % 64
    val mask = ~(1L << bucketDelta)
    buckets(bucket) &= mask
  }

  def contains(key: Int): Boolean = {
    val bucket = key / 64
    val bucketDelta = key % 64
    val mask = 1L << bucketDelta
    0 != (buckets(bucket) & mask)
  }
}