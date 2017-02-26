public class Solution {
  public void rotate(int [] nums, int k) {
    if(nums == null || nums.length <= 1 || k % nums.length == 0)
      return;
    final int modK = k % nums.length;
    final int [] ret = new int [nums.length];
    for(int i = 0; i<nums.length; i++)
        ret[i] = nums[i];
    for(int i = 0; i<nums.length; i++) {
        nums[i] = ret[(nums.length-modK+i)%nums.length];
    }
  }
}
