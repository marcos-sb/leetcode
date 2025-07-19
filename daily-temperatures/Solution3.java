class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final var n = temperatures.length;
        final var answer = new int[n];
        final var stack = new ArrayDeque<int[]>(n); // {i, temperatures[i]}

        for (var i = n-1; 0 <= i; --i) {
            final var t = temperatures[i];

            while (!stack.isEmpty() && stack.peek()[1] <= t) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                final var top = stack.peek();
                final var diff = top[0] - i;
                answer[i] = diff;
            }

            stack.push(new int[]{i, t});
        }

        return answer;
    }
}
