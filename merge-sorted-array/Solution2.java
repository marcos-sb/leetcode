class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var i = m-1;
        var j = n-1;
        for (var k = m+n-1; k >= 0; k--) {
            if (i < 0) nums1[k] = nums2[j--];
            else if (j < 0) nums1[k] = nums1[i--];
            else if (nums1[i] <= nums2[j]) nums1[k] = nums2[j--];
            else nums1[k] = nums1[i--];
        }
    }
}
