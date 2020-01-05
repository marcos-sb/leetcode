class MyHashMap() {
  private val buckets = Array.fill(1000001)(-1)
  def put(key: Int, value: Int): Unit = {
    buckets(key) = value
  }
  def get(key: Int): Int = {
    buckets(key)
  }
  def remove(key: Int): Unit = {
    buckets(key) = -1
  }
}