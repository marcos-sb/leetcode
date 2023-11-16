class Solution {
    private int targetSideLen;
    private int[] sums;

    public Solution() {
        targetSideLen = 0;
        sums = new int[4];
    }

    public boolean makesquare(int[] matchsticks) {
        // Check if it's possible to make a square.
        var perimeter = 0;
        for (var ms : matchsticks) perimeter += ms;
        targetSideLen = perimeter / 4;
        if (targetSideLen * 4 != perimeter) return false;

        // Sort ascending, but traverse descending.
        // This is because in Java you can't supply a custom Comparator
        // of a primitive type to Arrays.sort, and we don't want
        // to box that type if we can avoid it.
        Arrays.sort(matchsticks);

        return bt(matchsticks.length-1, matchsticks);
    }

    private boolean bt(int i, int[] ms) {
        // Base case: we have used all the matches. We have a square
        // iff all 4 sides (sums) are of the same length.
        if (i < 0)
            return sums[0] == sums[1] && sums[0] == sums[2] && sums[0] == sums[3];
        
        // Try adding the current match to each side.
        for (var j = 0; j < 4; j++) {
            if (sums[j] + ms[i] <= targetSideLen) {
                sums[j] += ms[i];
                if (bt(i-1, ms)) return true;
                sums[j] -= ms[i];
            }
        }

        return false;
    }
}
