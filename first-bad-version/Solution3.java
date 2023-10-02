/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        var lo = 0;
        var hi = n-1;
        while (lo < hi) {
            final var mid = lo + (hi-lo)/2;
            if(isBadVersion(mid+1)) hi = mid;
            else lo = mid+1;
        }
        return lo+1;
    }
}
