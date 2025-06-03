class Solution {
    public boolean find132pattern(int[] nums) {
        final var n = nums.length;
        if (n < 3) return false;

        final var stack = new ArrayDeque<Integer>();
        var second = Integer.MIN_VALUE;

        for (var i = n-1; 0 <= i; --i) {
            final var num = nums[i];
            if (num < second) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < num) {
                second = stack.pop();
            }

            stack.push(num);
        }

        return false;
    }
}
