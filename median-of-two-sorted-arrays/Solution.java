class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (A.length > B.length) {
            final int[] tmp = A;
            A = B;
            B = tmp;
        }
        final int M = A.length;
        final int N = B.length;
        final int total = M+N;
        final int half = total / 2;
        
        int l = 0, r = M-1;
        while (true) {
            int Amid = (int) Math.floor((r-l)/2d + l);
            int Bmid = half - Amid - 2;
            int Aleft = Amid < 0 ? Integer.MIN_VALUE : A[Amid];
            int Bleft = Bmid < 0 ? Integer.MIN_VALUE : B[Bmid];
            int Aright = Amid + 1 >= M ? Integer.MAX_VALUE : A[Amid+1];
            int Bright = Bmid + 1 >= N ? Integer.MAX_VALUE : B[Bmid+1];
            
            if (Aleft > Bright) r = Amid-1;
            else if (Bleft > Aright) l = Amid+1;
            else {
                if (total % 2 == 1)
                    return (double) Math.min(Aright, Bright);
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2d;
            }
        }
    }
}
