class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var left = 1;
        var right = getMax(piles);

        while (left < right) {
            final var mid = left + (right-left) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    private static int getMax(int[] piles) {
        var max = 0;
        for (var p : piles) {
            max = Math.max(max, p);
        }
        return max;
    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        var hours = 0;

        for (var p : piles) {
            hours += (p + speed - 1) / speed;
            if (h < hours) return false;
        }

        return hours <= h;
    }
}
