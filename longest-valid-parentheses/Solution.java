class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;

        final var stack = new ArrayDeque<Integer>();
        final var valid = new ArrayDeque<int[]>();
        for (var j = 0; j < s.length(); j++) {
            final var c = s.charAt(j);
            if (c == '(') stack.offerLast(j);
            else {
                if (stack.isEmpty()) continue;
                final var i = stack.pollLast();
                final var curr = new int[]{i,j};
                while (!valid.isEmpty()) {
                    final var validIJ = valid.peekLast();
                    if (curr[0]+1 == validIJ[0] || validIJ[1] == curr[0]-1) {
                        valid.pollLast();
                        curr[0] = Math.min(validIJ[0], curr[0]);
                        curr[1] = Math.max(validIJ[1], curr[1]);
                    } else break;
                }
                valid.offerLast(curr);
            }
        }

        var maxLen = 0;
        for (var interval : valid)
            maxLen = Math.max(maxLen, interval[1] - interval[0] + 1);

        return maxLen;
    }
}
