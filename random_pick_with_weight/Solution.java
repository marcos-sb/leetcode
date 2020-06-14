class Solution {
    private final float[] distr;
    
    public Solution(int[] ws) {
        distr = new float [ws.length];
        
        int total = 0;
        for (int w : ws) total += w;
        float sum = 0;
        for (int i = 0; i < ws.length-1; i++) {
            sum += ws[i]/(float)total;
            distr[i] = sum;
        }
        distr[distr.length-1] = 1.0f;
    }
    
    public int pickIndex() {
        final float f = ThreadLocalRandom.current().nextFloat();
        int lo = 0;
        int hi = distr.length-1;
        int mid = 0;
        while (lo <= hi) {
            mid = (hi-lo)/2 + lo;
            if (f < distr[mid]) {
                if ((mid-1 >= 0 && distr[mid-1] < f) || mid == 0) {
                    return mid;
                }
                hi = mid-1;
            } else if (distr[mid] < f) {
                lo = mid+1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
