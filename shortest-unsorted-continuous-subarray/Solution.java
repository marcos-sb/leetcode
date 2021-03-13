class Solution {
    public int findUnsortedSubarray(int[] nums) {
        final var st = new ArrayDeque<Integer>(nums.length);
        var left = nums.length;
        st.offerLast(0);
        
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peekLast()] > nums[i]) {
                left = Math.min(st.pollLast(), left);
            }
            st.offerLast(i);
        }
        
        if (left == nums.length) return 0;
        
        var right = -1;
        st.clear();
        st.offerLast(nums.length-1);
        for (int i = nums.length-2; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peekLast()] < nums[i]) {
                right = Math.max(st.pollLast(), right);
            }
            st.offerLast(i);
        }
        
        return right - left + 1;
    }
}
