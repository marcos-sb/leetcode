/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        var left = 0;
        var right = n;
        while (left < right) {
            final var mid = (right-left)/2 + left;
            if (isBadVersion(mid)) right = mid;
            else left = mid+1;
        }
        
        return left; // left == right
    }
}
