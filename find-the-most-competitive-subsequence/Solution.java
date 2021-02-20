class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        final Deque<Integer> st = new ArrayDeque<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] < st.peekLast() && st.size() + nums.length - i > k)
                st.pollLast();
            if (st.size() < k)
                st.offerLast(nums[i]);
        }

        return st.stream().mapToInt(i -> i).toArray();
    }
}
