class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        final Map<Integer, Integer> n34Freqs = new HashMap<>(nums4.length);
        for (int n3 : nums3)
            for (int n4 : nums4) {
                final int _sum34 = -(n3+n4);
                n34Freqs.put(_sum34, n34Freqs.getOrDefault(_sum34,0)+1);
            }
        
        int count = 0;
        for (int n1 : nums1)
                for (int n2 : nums2) {
                    final int sum12 = n1+n2;
                    count += n34Freqs.getOrDefault(sum12, 0);
                }

        return count;
    }
}
