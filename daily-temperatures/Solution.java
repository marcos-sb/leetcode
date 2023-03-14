class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final var N = temperatures.length;
        final var stack = new ArrayList<int[]>(N);
        final var res = new int[N];
        
        for (var i = N-1; 0 <= i; i--) {
            final var t = temperatures[i];
            while (!stack.isEmpty() && stack.get(stack.size()-1)[0] <= t)
                stack.remove(stack.size()-1);
            if (stack.isEmpty()) res[i] = 0;
            else res[i] = stack.get(stack.size()-1)[1] - i;
            stack.add(new int[]{t, i});
        }
        
        return res;
    }
}
