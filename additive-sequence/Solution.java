class Solution {
  public boolean isAdditiveNumber(String s) {
    if (s == null || s.length() < 3) return false;
    return bt(s, 0, new ArrayList<>());
  }
  private static boolean bt(String s, int i, List<Integer> nums) {
    if (i >= s.length()) {
      if (nums.size() >= 3) return true;
      return false;
    } 

    for (int j = 1; j < 10 && i+j <= s.length(); j++) {
      final int n = Integer.parseInt(s.substring(i, i+j));
      if (nums.size() >= 2) {
        final int n_1 = nums.get(nums.size()-1);
        final int n_2 = nums.get(nums.size()-2);
        if (n < n_1 + n_2) continue;
        if (n > n_1 + n_2) return false;
      }
      nums.add(n);
      if (bt(s, i+j, nums)) return true;
      nums.remove(nums.size()-1);
    }

    return false;
  }
}
