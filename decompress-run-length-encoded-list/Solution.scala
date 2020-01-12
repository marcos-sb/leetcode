object Solution {
  import collection.mutable
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    val res = mutable.Buffer[Int]()
    for (i <- 0 to nums.length-2 by 2)
      for (_ <- 0 until nums(i))
        res += nums(i+1)
    res.toArray
  }
}