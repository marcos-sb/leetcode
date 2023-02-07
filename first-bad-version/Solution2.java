/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        var lo = 1;
        var hi = n;
        while (lo < hi) {
            final var mid = (hi-lo)/2 + lo;
            // 'mid' might be the result we want to return;
            // that's why we include it in the search space of
            // the next interation
            if (isBadVersion(mid)) hi = mid; 
            else lo = mid+1; // 'mid' in this case is certainly not the result
        }
        return lo;
    }
}
