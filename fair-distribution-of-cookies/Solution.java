class Solution {
    private int minUnfairness = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        final var distribution = new int[k];
        bt(cookies, 0, distribution);
        return minUnfairness;
    }

    private void bt(int[] cookies, int i, int[] distribution) {
        if (i == cookies.length) {
            var max = 0;
            for (var d : distribution) {
                max = Math.max(max, d);
            }
            minUnfairness = max;
            return;
        }

        for (var j = 0; j < distribution.length; ++j) {
            distribution[j] += cookies[i];
            if (distribution[j] < minUnfairness) {
                bt(cookies, i+1, distribution);
            }
            distribution[j] -= cookies[i];
            if (distribution[j] == 0) {
                break;
            }
        }
    }
}
