class Solution {
    public int shipWithinDays(int[] weights, int days) {
        var left = weights[0];
        var right = weights[0];
        for (var w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            final var mid = left + (right-left)/2;
            if (canShipWithCurrentCap(mid, days, weights)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShipWithCurrentCap(int cap, int days, int[] ws) {
        var numDays = 1;
        var currLoad = 0;
        for (var w : ws) {
            currLoad += w;
            if (cap < currLoad) {
                currLoad = w;
                if (++numDays > days) {
                    return false;
                }
            }
        }
        return true;
    }
}
