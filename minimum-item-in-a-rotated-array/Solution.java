class Solution {
  public int findMin(int[] nums) {
    if (nums == null) return -1;
    if (nums.length == 0) return -1;

    var lo = 0;
    var hi = nums.length-1;
    var mid = 0;
    while (lo < hi) {
      mid = (hi-lo)/2 + lo;
      if (nums[mid] < nums[hi]) hi = mid;
      else if (nums[mid] > nums[hi]) lo = mid+1;
    }

    return nums[lo];
  }
}
