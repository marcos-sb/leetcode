class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final var T = temperatures.length;
        final var stack = new ArrayDeque<Integer>();
        final var res = new int[T];
        for (var i = T-1; 0 <= i; i--) {
            final var t = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= t) {
                stack.pop();
            }
            if (stack.isEmpty()) res[i] = 0;
            else res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
