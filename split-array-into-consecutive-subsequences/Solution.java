class Solution {
    public boolean isPossible(int[] nums) {
        final var n = nums.length;
        final var count = new int[2003];
        for (var num : nums) {
            ++count[num+1001];
        }

        final var endCount = new int[2002];

        for (var num : nums) {
            final var numIdx = num+1001;
            if (count[numIdx] == 0) continue;

            if (0 < endCount[numIdx-1]) {
                --endCount[numIdx-1];
                ++endCount[numIdx];
                --count[numIdx];
            } else if (0 < count[numIdx+1] && 0 < count[numIdx+2]) {
                --count[numIdx];
                --count[numIdx+1];
                --count[numIdx+2];
                ++endCount[numIdx+2];
            } else {
                return false;
            }
        }

        return true;
    }
}
