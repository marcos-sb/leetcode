class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        final var freq1 = freqs(nums1);
        final var freq2 = freqs(nums2);
        
        final var ret = new ArrayList<Integer>();
        for (var i = 0; i < 1001; i++)
            while (freq1[i]-- > 0 && freq2[i]-- > 0)
                ret.add(i);
        
        final var retArr = new int[ret.size()];
        for (var i = 0; i < retArr.length; i++)
            retArr[i] = ret.get(i);
        
        return retArr;
    }
    
    private static int[] freqs(int[] arr) {
        final var ret = new int[1001];
        for (var n : arr) ret[n]++;
        return ret;
    }
}
