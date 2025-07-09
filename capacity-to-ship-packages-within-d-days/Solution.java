class Solution {

    public int shipWithinDays(int[] weights, int days) {
        var left = 0;
        var right = 0;
        for (var weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            final var mid = left + (right - left) / 2;
            if (canShipWithCurrCap(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private static boolean canShipWithCurrCap(
        int[] weights,
        int days,
        int maxCap
    ) {
        var cap = 0;
        var numDays = 1;
        for (var weight : weights) {
            if (maxCap < cap + weight) {
                if (days < ++numDays) {
                    return false;
                }
                cap = weight;
            } else {
                cap += weight;
            }
        }

        return true;
    }
}
