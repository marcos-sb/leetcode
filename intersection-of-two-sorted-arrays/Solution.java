class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) return null;
    if (nums1.length == 0 || nums2.length == 0)
      return new int[0];

    final var res = new ArrayList<Integer>();
    var i = 0;
    var j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) i++;
      else if (nums1[i] > nums2[j]) j++;
      else { // nums1[i] == nums2[j]
        if ((!res.isEmpty() && nums1[i] != res.get(res.size()-1)) || res.isEmpty())
          res.add(nums1[i]);
        i++; j++;
      }
    }
    
    return res.stream().mapToInt(k->k).toArray();
  }
}
