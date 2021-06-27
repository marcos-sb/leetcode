class Solution {
  public int Four_Sum(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    final Map<Integer, Integer> freqs = new HashMap<>();
    for (int i = 0; i < nums1.length; i++)
      for (int j = 0; j < nums2.length; j++)
        freqs.put(nums1[i]+nums2[j], freqs.getOrDefault(nums1[i]+nums2[j], 0) + 1);
    
    int count = 0;
    for (int i = 0; i < nums3.length; i++)
      for (int j = 0; j < nums4.length; j++)
        count += freqs.getOrDefault(-(nums3[i]+nums4[j]),0);
    
    return count;
  }
}
